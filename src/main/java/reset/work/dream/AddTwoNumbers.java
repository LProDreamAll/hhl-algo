package reset.work.dream;

import common.json.JSON;
import lombok.Data;

/**
 * addTwoNumbers
 * https://leetcode.cn/problems/add-two-numbers/
 */
public class AddTwoNumbers {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            System.out.println("x = " + x);
            System.out.println("y = " + y);
            int temp = x + y + carry;
            carry = temp / 10;
            System.out.println("cur node before:"+ JSON.toJSONString(cur));
            System.out.println("head node before:"+JSON.toJSONString(head));
            cur.next = new ListNode(temp % 10);
            System.out.println("cur next ing :"+JSON.toJSONString(cur));
            System.out.println("head next ing :"+JSON.toJSONString(head));
            cur = cur.next;
            System.out.println("cur next after :"+JSON.toJSONString(cur));
            System.out.println("head next after :"+JSON.toJSONString(head));
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return head.next;
    }



    public static void main(String[] args) {
        //[2,4,3] + [5,6,4] = [7,0,8]
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(3)));
        System.out.println(l1.val);
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));
        System.out.println(l2.val);
        ListNode listNode = addTwoNumbers(l1, l2);
        System.out.println(JSON.toJSONString(listNode));
//
//        ListNode listNode1 = addTwoNumbers1(l1, l2);
//        System.out.println(JSON.toJSONString(listNode1));

    }

    public static ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode cur = new ListNode(0);
//      ListNode cur = head;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int temp = x + y + carry;

            carry = temp / 10;
            System.out.println("cur node before:"+JSON.toJSONString(cur));
            cur.next = new ListNode(temp % 10);
            System.out.println("cur next ing :"+JSON.toJSONString(cur));
            cur = cur.next;
            System.out.println("cur next after :"+JSON.toJSONString(cur));
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return cur.next;
    }
    @Data
    static public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
