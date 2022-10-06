package ru.job4j.collection;

public interface MyInterface<E> extends Iterable<E> {
    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    void update(int index, E e);
}
