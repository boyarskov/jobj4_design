package ru.job4j.collection;

import java.util.Iterator;

public class MyArray<E> implements MyInterface<E> {

    public static void main(String[] args) {
        MyInterface<String> strings = new MyArray<>();
        strings.add("one");
        strings.add("two");
        strings.add("three");
        strings.add("four");
        strings.update(0, "update");
        strings.delete(1);

        for (int i = 0; i < strings.size(); i++) {
            System.out.println(strings.get(i));
        }
    }

    private E[] values;

    MyArray() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(E e) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length + 1];
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = e;
            return true;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
            values = (E[]) new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElementAfrerIndex = temp.length - index - 1;
            System.arraycopy(temp, index + 1, values, index, amountElementAfrerIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public void update(int index, E e) {
        values[index] = e;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyArrayIterator<>(values);
    }
}
