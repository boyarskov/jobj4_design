package ru.job4j.collection;

import org.w3c.dom.Node;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/**
 * Динамический контейнер на базе связанного списка.
 *
 * @author Artem Boyarskov (boyarskov.com)
 */
public class SimpleLinkedList<E> implements LinkedList<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size;
    private int modCount;

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E currentElement, Node<E> next) {
            this.item = currentElement;
            this.next = next;
        }
    }

    @Override
    public void add(E value) {
        final Node<E> last = lstNode;
        Node newNode = new Node<>(value, null);
        lstNode = newNode;
        if (last == null) {
            fstNode = newNode;
        } else {
            last.next = newNode;
        }
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> rsl = fstNode;
        for (int i = 1; i <= index; i++) {
            rsl = rsl.next;
        }
        return rsl.item;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int expectedModCount = modCount;
            SimpleLinkedList.Node<E> point = fstNode;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E value = point.item;
                point = point.next;
                return value;
            }
        };
    }
}
