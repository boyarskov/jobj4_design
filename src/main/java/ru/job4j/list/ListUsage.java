package ru.job4j.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = List.of("one", "two", "three");
        Iterator<String> iterator = rsl.iterator();
        for (int i = 0; i < rsl.size(); i++) {
            System.out.println("Текущий элемент, через get: " + rsl.get(i));
        }
        while (iterator.hasNext()) {
            System.out.println("Текущий элемент, через iterator: " + iterator.next());
        }
        System.out.println("Размер списка равен: " + rsl.size());
    }
}
