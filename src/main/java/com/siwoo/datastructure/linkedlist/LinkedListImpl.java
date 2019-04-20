package com.siwoo.datastructure.linkedlist;

import com.siwoo.datastructure.stack.Stack;

import java.lang.reflect.Array;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedListImpl<E> implements LinkedList<E>, Stack<E> {
    //top element (the most recent element) of the list.
    private Node<E> last;
    private Node<E> first;
    private transient int size = 0;

    private static class Node<E> {
        private E el;
        //reference which is added earlier than the node
        private Node prev;
        //reference which is added later than the node
        private Node next;

        public Node(E el) {
            this.el = el;
        }

        @Override
        public String toString() {
            return el == null ? "null" : el.toString();
        }

    }
    @Override
    public void addLast(E el) {
        final Node<E> l = last;
        final Node<E> newNode = new Node<>(el);
        newNode.prev = last;
        if (l == null)
            first = newNode;
        else
            l.next = newNode;
        last = newNode;
        size++;
    }

    @Override
    public E removeLast() {
        if (last == null)
            throw new NoSuchElementException();
        final Node<E> l = last;
        final Node<E> prev = l.prev;
        final E element = l.el;

        if (prev == null)
            first = null;
        else
            prev.next = null;

        last = prev;
        size--;
        //GC
        l.el = null;
        l.prev = null;
        return element;
    }

    @Override
    public void addFirst(E el) {
        final Node<E> f = first;
        final Node<E> newNode = new Node<>(el);
        newNode.next = first;
        if (f == null)
            last = newNode;
        else
            f.prev = newNode;
        first = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        if (first == null)
            throw new NoSuchElementException();
        final Node<E> f = first;
        final Node<E> next = f.next;
        final E element = f.el;

        if (next == null)
            last = null;
        else
            next.prev = null;

        first = next;
        size--;
        //GC
        f.el = null;
        f.next = null;
        return element;
    }

    @Override
    public boolean isEmpty() {
        return last == null;
    }

    @Override
    public void push(E item) {
        addLast(item);
    }

    @Override
    public E pop() {
        return removeLast();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E peek() {
        if (isEmpty())
            throw new NoSuchElementException();
        return last.el;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        int i = 0;
        for (Node c = last; c != null; c = c.prev)
            result[i++] = c.el;
        return result;
    }

    @Override
    public <T> T[] toArray(T[] array) {
        if (array.length < size)
            array = (T[]) Array.newInstance(
                    array.getClass().getComponentType(), size);

        int i = 0;
        Object[] result = array;
        for (Node c = last; c != null; c = c.prev)
            result[i++] = c.el;

        //what is the situation for the condition?
        if (array.length > size)
            array[size] = null;
        return array;
    }

    @Override
    public Iterator<E> iterator() {
        return new Itr<>(last);
    }

    private class Itr<E> implements Iterator<E>{
        private Node<E> c;
        private Node<E> lastReturned;

        public Itr(Node<E> last) {
            this.c = last;
        }

        @Override
        public boolean hasNext() {
            return c != null;
        }

        @Override
        public E next() {
            if (!hasNext())
                throw new NoSuchElementException();
            lastReturned = c;
            c = c.prev;
            return lastReturned.el;
        }
    }

}
