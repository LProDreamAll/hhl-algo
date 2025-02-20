package org.hhl.common.structure.stack;

import lombok.Data;
import org.hhl.common.json.JSON;
import org.hhl.common.node.Node;

/**
 * 下压栈
 * @param <T>
 */
@Data
public class SimpleListNodeStack<T>{
    private Node<T> first;
    private int N;
    public boolean isEmpty(){
        return N == 0;
    }
    public int size(){
        return N;
    }

    /**
     * 头结点插入
     * @param t
     */
    public void push(T t){
        Node<T> old = first;
        first = new Node<>(t,old);
        N++;
    }

    /**
     * 弹出头结点
     * @return
     */
    public T pop(){
        T t = first.getT();
        first = first.getNext();
        return t;
    }

    public static void main(String[] args) {
        SimpleListNodeStack<Integer> simpleListStack = new SimpleListNodeStack<>();
        simpleListStack.push(1);
        simpleListStack.push(2);
        simpleListStack.push(3);
        System.out.println("size = " + simpleListStack.size());
        System.out.println("simpleListStack = " + JSON.toJSONString(simpleListStack));
        Integer pop1 = simpleListStack.pop();
        System.out.println("pop1 = " + pop1);
        Integer pop2 = simpleListStack.pop();
        System.out.println("pop2 = " + pop2);
        Integer pop3 = simpleListStack.pop();
        System.out.println("pop3 = " + pop3);
    }
}
