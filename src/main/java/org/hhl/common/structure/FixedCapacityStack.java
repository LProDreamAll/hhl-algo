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
        if (n == arr.length){
            resize(2*n);
        }
        arr[n++] = t;
    }

    /**
     * 返回栈顶并删除
     *
     * @return
     */
    public T pop() {
        Object t = arr[--n];
        //当n==1/4 len 的时候，已经被删除了3/4了,此时只剩了1/4，改成1/2能够满足后续的增加和删除,使用率不会低于1/4
        if (n == arr.length/4){
            resize(2*n);
        }
        return (T)t ;
    }

    public boolean isEmpty() {
        return n == 0;
    }

    public int size() {
        return n;
    }
    private void resize(int max){
        Object[] temp= new Object[max];
        for (int i = 0; i <n ; i++) {
            temp[i] = arr[i];
        }
        arr = temp;
    }
}
