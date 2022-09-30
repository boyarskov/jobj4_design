package ru.job4j.generics;

import java.util.HashMap;
import java.util.Map;

public class MemStore<T extends Base> implements Store<T> {
    private final Map<String, T> storage = new HashMap<>();
// ключом будет являться id нашей модели, а значением - объект,
// который мы будем хранить в хранилище,
// в данном случае это обобщенный тип T.

    /*
    Для реализации используйте методы из интерфейса  java.util.Map, наиболее подходящие под требования задания.
     */
    @Override
    public void add(T model) {
        /*
        add() - метод добавляет в хранилище объект типа T, при этом метод ничего не возвращает.
        Если добавляемый объект уже присутствует в хранилище, то добавления не происходит.
         */
    }

    @Override
    public boolean replace(String id, T model) {
        /*
        replace() - метод выполняет замену объекта по id, на объект который передается
        в параметрах метода и возвращает true, если замена выполнена успешно;
         */
        return false;
    }

    @Override
    public boolean delete(String id) {
        /*
         delete() - метод удаляет пару ключ-значение по id,
         который передается в метод и возвращает true, если удаление выполнено успешно;
         */
        return false;
    }

    @Override
    public T findById(String id) {
        /*
        findById() - метод возвращает объект по ключу, который равен id, передаваемый в качестве параметра метода
        или возвращает null если по такому ключу в Map еще нет пару ключ-значение.
         */
        return null;
    }
}
