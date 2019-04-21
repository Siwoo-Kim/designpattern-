package com.siwoo.datastructure.queue;

public interface Queue<E> {

    void add(E element);

    E remove();

    E peek();

    int size();


    boolean isEmpty();

    <T> T[] toArray(T[] a);
}
