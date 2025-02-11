package org.hhl.common.structure;

/**
 * 定容的栈
 *
 * @param <T>
 */
public class FixedCapacityStack<T> {
    private Object[] arr;
    private int n;

    FixedCapacityStack(int cap) {
        arr = (T[]) new Object[cap];
    }

    public void push(T t) {
        arr[n++] = t;
    }

    /**
     * 返回栈顶并删除
     *
     * @return
     */
    public T pop() {
        return (T) arr[--n];
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }
}
