package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        while (row < data.length && column == data[row].length) {
            row++;
            column = 0;
  //... изменяем индексы для перехода к следующему элементу ...;
        }
        return row < data.length;
        //return row < data.length && column < data[row].length;
                //(...  проверка соответствия найденного элемента требованиям итератора);
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
        //(..возвращаем элемент по индексам и увеличиваем индекс..);
    }
}
