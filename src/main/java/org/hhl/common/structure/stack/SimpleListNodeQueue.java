package org.hhl.common.structure.stack;

import lombok.Data;
import org.hhl.common.json.JSON;
import org.hhl.common.node.Node;

import javax.print.DocFlavor;

/**
 * 先进先出队列
 *
 * @param <T>
 */
@Data
public class SimpleListNodeQueue<T> {
    //最早添加的结点的链接
    private Node<T> first;
    //最近添加的那一个结点
    private Node<T> last;
    private int N;

    /**
     * 队列尾部添加元素
     *
     * @param t
     */
    public void push(T t) {
        Node<T> oldLast = last;
        last = new Node<>(t, null);
        if (isEmpty()) {
            first = last;
        } else {
            //这个赋值中的oldLast是整个对象的第一个节点
            oldLast.setNext(last);
        }
        N++;
    }

    /**
     * 弹出头结点
     *
     * @return
     */
    public T pop() {
        T t = first.getT();
        first = first.getNext();
        if (isEmpty()) {
            last = null;
        }
        N--;
        return t;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public static void main(String[] args) {
        SimpleListNodeQueue<Integer> simpleListNodeQueue = new SimpleListNodeQueue<>();
        simpleListNodeQueue.push(1);
        System.out.println("simpleListNodeQueue1 = " + JSON.toJSONString(simpleListNodeQueue));
        simpleListNodeQueue.push(2);
        System.out.println("simpleListNodeQueue2 = " + JSON.toJSONString(simpleListNodeQueue));
        simpleListNodeQueue.push(3);
        System.out.println("simpleListNodeQueue3 = " + JSON.toJSONString(simpleListNodeQueue));
        Integer pop1 = simpleListNodeQueue.pop();
        System.out.println("pop1 = " + pop1);
        System.out.println("simpleListNodeQueue pop1 = " + JSON.toJSONString(simpleListNodeQueue));
        Integer pop2 = simpleListNodeQueue.pop();
        System.out.println("pop2 = " + pop2);
        System.out.println("simpleListNodeQueue pop2 = " + JSON.toJSONString(simpleListNodeQueue));
        Integer pop3 = simpleListNodeQueue.pop();
        System.out.println("pop3 = " + pop3);
        System.out.println("simpleListNodeQueue pop3 = " + JSON.toJSONString(simpleListNodeQueue));
    }
}
