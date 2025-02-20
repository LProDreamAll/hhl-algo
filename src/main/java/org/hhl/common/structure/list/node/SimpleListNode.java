package org.hhl.common.structure.list.node;

import lombok.Getter;
import org.hhl.common.node.Node;
@Getter
public class SimpleListNode<T> {
    private Node<T> first;

    /**
     * 头部插入节点
     * @return
     */
    public void addFirstNode(T t){
        Node<T> old = first;
        first = new Node<>();
        first.setT(t);
        first.setNext(old);
    }
    /**
     * 删除头结点
     * @return
     */
    public void delFirstNode(){
        first = first.getNext();
    }
    /**
     * 插入尾节点
     * @return
     */
    public void addLastNode(T t){
        Node<T> old = first;
        first = new Node<>();
        first.setT(t);
        old.setNext(first);

    }
}
