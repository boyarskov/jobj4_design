package ru.job4j.iterator;

import java.util.*;
import java.util.function.Predicate;

public class ListUtils {
    public static <T> void addBefore(List<T> list, int index, T value) {
        //метод который будет вставлять значение перед индексом
        Objects.checkIndex(index, list.size());
        ListIterator<T> iterator = list.listIterator();
        while (iterator.hasNext()) {
            if (iterator.nextIndex() == index) {
                iterator.add(value);
                break;
            }
            iterator.next();
        }
    }

    public static <T> void addAfter(List<T> list, int index, T value) {
        //addAfter() вставляет после индекса;

    }

    public static <T> void addBefore(List<T> list, int index, int x) {
        //addBefore() вставляет до индекса

    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {
        //removeIf() удаляет все элементы, которые удовлетворяют предикату.
        // Запрещено использовать метод List.removeIf;

    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        //replaceIf() заменяет все элементы, которые удовлетворяют предикату;
    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        //removeAll() удаляет из списка те элементы, которые есть в elements
        //Запрещено использовать метод List.removeAll().

    }


}
