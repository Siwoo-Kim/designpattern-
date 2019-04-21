package com.siwoo.datastructure.queue;

import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Queue;

public class ArrayQueue<E> implements Queue<E> {
    private static final int MIN_INITIAL_CAPACITY = 8;
    private Object[] elements;
    private int head;
    private int tail;

    public ArrayQueue() {
        this(MIN_INITIAL_CAPACITY);
    }

    public ArrayQueue(int capacity) {
        elements = new Object[capacity];
    }

    /**
     * Inserts the specified element at the end of this deque.
     *
     * @param e the element to add
     * @throws NullPointerException if the specified element is null
     */
    @Override
    public boolean add(E e) {
        if (e == null)
            throw new NullPointerException();
        //resize the queue before it is full
        if (size() == elements.length - 1) {
            doubleCapacity();
        }
        elements[tail] = e;
        //If the next tail is equal to the capacity
        //left part of the array has empty spot
        if (tail == elements.length - 1)
            tail = 0;
        else
            tail++;
        return true;
    }

    private void doubleCapacity() {
        final int size = size();
        int r = elements.length - head;
        Object[] a = new Object[(size << 1) + 1];
        System.arraycopy(elements, head, a, 0, r);
        System.arraycopy(elements, 0, a, r, tail);
        elements = a;
        head = 0;
        tail = size;
    }

    @Override
    public int size() {
        if (head <= tail)
            return tail - head;
        else
            return (elements.length-head) + tail;
    }

    @Override
    public boolean isEmpty() {
        return head == tail;
    }

    @Override
    public Object[] toArray() {
        return toArray(new Object[size()]);
    }

    public int getCapacity() {
        return elements.length;
    }

    @Override
    public <T> T[] toArray(T[] a) {
        final int size = size();
        if (a.length < size)
            a = (T[]) Array.newInstance(
                    a.getClass().getComponentType(), size);
        copyElements(a);
        if (a.length > size)
            a[size] = null;
        return a;
    }

    private <T> T[] copyElements(T[] a) {
        if (tail > head)
            System.arraycopy(elements, head, a, 0, size());
        else if (tail < head) {
            final int numOfRight = elements.length - head;
            System.arraycopy(elements, head, a, 0, numOfRight);
            System.arraycopy(elements, 0, a, numOfRight, tail);
        } else {
            //queue is empty
        }
        return a;
    }

    @Override
    public boolean offer(E e) {
        add(e);
        return true;
    }

    /**
     * Retrieves and removes the head of this queue.  This method differs
     * from {@link #poll poll} only in that it throws an exception if this
     * queue is empty.
     *
     * @return the head of this queue
     * @throws NoSuchElementException if this queue is empty
     */
    @Override
    public E remove() {
        E el = poll();
        if (el == null)
            throw new NoSuchElementException();
        return el;
    }

    /**
     * Retrieves and removes the head of this queue,
     * or returns {@code null} if this queue is empty.
     *
     * @return the head of this queue, or {@code null} if this queue is empty
     */
    @Override
    public E poll() {
        final E el = (E) elements[head];
        if (el == null)
            return null;
        elements[head++] = null;

        if (head == tail)
            head = tail = 0;
            //recycle
        else if (head == elements.length)
            head = 0;
        return el;
    }

    @Override
    public E element() {
        return null;
    }

    @Override
    public E peek() {
        // elements[head] is null if deque empty
        return (E) elements[head];
    }


    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean contains(Object o) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

}
