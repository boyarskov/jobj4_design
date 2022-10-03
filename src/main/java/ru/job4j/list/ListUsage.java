package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

public class ListUsage {
    public static void main(String[] args) {
        List<String> rsl = new ArrayList<>();
        List<String> list = new ArrayList<>();
        List<String> listAll = new ArrayList<>();
        rsl.add("one");
        rsl.add("two");
        rsl.add("three");
        rsl.add(1, "new one");
        list.add("four");
        list.add("five");
        rsl.addAll(list);
        listAll.add("four2");
        listAll.add("five2");
        rsl.addAll(5, listAll);
        for (String s : rsl) {
            System.out.println("Текущий элемент: " + s);
        }
    }
}
