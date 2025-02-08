package org.hhl.common.node;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
    }

}
