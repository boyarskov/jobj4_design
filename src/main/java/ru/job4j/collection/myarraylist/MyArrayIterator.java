package ru.job4j.collection.myarraylist;

import java.util.Iterator;

public class MyArrayIterator<E> implements Iterator<E> {
    private int index = 0;
    E[] values;

    MyArrayIterator(E[] values) {
        this.values = values;
    }

    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    @Override
    public E next() {
        return values[index++];
    }
}
