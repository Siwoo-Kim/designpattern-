package com.siwoo.datastructure.linkedlist;

import java.util.Iterator;

public interface LinkedList<E> extends Iterable<E> {

    void addLast(E el);

    void addFirst(E el);

    E removeLast();

    E removeFirst();

    default boolean isEmpty() {
        return size() == 0;
    };

    int size();

    Object[] toArray();

    <T> T[] toArray(T[] array);
}
