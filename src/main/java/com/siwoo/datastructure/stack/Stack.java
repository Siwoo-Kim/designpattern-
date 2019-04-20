package com.siwoo.datastructure.stack;

public interface Stack<E> {

    void push(E item);

    E pop();

    int size();

    E peek();

    boolean isEmpty();

    <T> T[] toArray(T[] a);
}
