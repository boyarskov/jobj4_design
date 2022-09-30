package ru.job4j.generics;

public class UserStore implements Store<User> {
    private final Store<User> store = new MemStore<>();

/*
Здесь методы будут делать тоже самое, что и в универсальном хранилище MemStore. Однако заново реализовывать методы
нам уже не придется, мы можем просто вызывать реализации этих методов из MemStore,
поскольку объект именно этого типа мы используем в качестве хранилища.
 */
    @Override
    public void add(User model) {

    }

    @Override
    public boolean replace(String id, User model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public User findById(String id) {
        return null;
    }
}
