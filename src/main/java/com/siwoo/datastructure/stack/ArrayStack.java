package com.siwoo.datastructure.stack;

import java.lang.reflect.Array;
import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class ArrayStack<E> implements Stack<E> {
    private static final int MIN_INITIAL_CAPACITY = 8;
    private Object[] elements;
    private int head;

    public ArrayStack() {
        this(MIN_INITIAL_CAPACITY);
    }

    public ArrayStack(int capacity) {
        this.elements = new Object[capacity];
    }

    @Override
    public void push(E item) {
        if (head == elements.length) {
            doubleCapacity();
        }
        elements[head++] = item;
    }

    private void doubleCapacity() {
        final int size = elements.length;
        Object[] a = new Object[size << 1];
        System.arraycopy(elements, 0, a, 0, size);
        elements = a;
    }

    @Override
    public E pop() {
        if (isEmpty())
            throw new EmptyStackException();
        final E el = (E) elements[--head];
        elements[head] = null;
        return el;
    }

    @Override
    public int size() {
        return head;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new EmptyStackException();
        return (E) elements[head - 1];
    }

    @Override
    public boolean isEmpty() {
        return head == 0;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        int size = size();
        if (a.length < size)
            a = (T[]) Array.newInstance(
                    a.getClass().getComponentType(), size());
        int j = 0;
        for (int i = size - 1; i >= 0; i--) {
            a[j++] = (T) elements[i];
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }
}
