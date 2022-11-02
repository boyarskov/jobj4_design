package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> inS2 = new SimpleStack<>();
    private final SimpleStack<T> outS1 = new SimpleStack<>();

    public T poll() {
        if (outS1.isEmpty() && inS2.isEmpty()) {
            throw new NoSuchElementException();
        }

        if (outS1.isEmpty()) {
            while (!inS2.isEmpty()) {
                outS1.push(inS2.pop());
            }
        }
        return outS1.pop();
    }

    public void push(T value) {
        inS2.push(value);
    }
}