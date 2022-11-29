package ru.job4j.collection.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Map<User, Object> maps = new HashMap<>(16);

        Calendar hbUser = new GregorianCalendar(1980, 11, 21);

        User user1 = new User("Petr", 1, hbUser);
        User user2 = new User("Artem", 0, hbUser);

        maps.put(user1, hbUser);
        maps.put(user2, hbUser);

        int hashCode1 = user1.hashCode();
        int hash1 = hashCode1 ^ (hashCode1 >>> 16);
        int bucket1 = hash1 & 15;

        int hashCode2 = user2.hashCode();
        int hash2 = hashCode2 ^ (hashCode2 >>> 16);
        int bucket2 = hash2 & 15;

        System.out.printf("user1 - хэшкод: %s, хэш: %s, бакет: %s",
                hashCode1, hash1, bucket1);
        System.out.println();
        System.out.printf("user2 - хэшкод: %s, хэш: %s, бакет: %s",
                hashCode2, hash2, bucket2);
    }


}