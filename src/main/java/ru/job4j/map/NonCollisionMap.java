package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class NonCollisionMap<K, V> implements SimpleMap<K, V> {
    private static final float LOAD_FACTOR = 0.75f;
    private int capacity = 8;
    private int count = 0;
    private int modCount = 0;
    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int index = getIndexByKey(key);

        if (table[index] != null) {
           return false;
        } else {
            table[index] = new MapEntry<>(key, value);
            modCount++;
            count++;
        }

        if ((float) count / capacity >= LOAD_FACTOR) {
            expand();
            return true;
        }
        return true;
    }

    @Override
    public V get(K key) {
        int index = getIndexByKey(key);
        MapEntry<K, V> entry = table[index];

        if (keysMatch(key, entry)) {
            return entry.value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        int index = getIndexByKey(key);
        MapEntry<K, V> entry = table[index];

        if (keysMatch(key, entry)) {
            table[index] = null;
            modCount++;
            count--;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new NonCollisionMapKeyIterator();
    }

    private class NonCollisionMapKeyIterator implements Iterator<K> {
        private final int expectedModCount = modCount;
        private int index = 0;

        @Override
        public boolean hasNext() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }
            while (index < table.length && table[index] == null) {
                index++;
            }
            return index < table.length;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return table[index++].key;
        }
    }

    private int hash(Object key) {
        if (key == null) {
            return 0;
        }
        int h = key.hashCode();
        return h ^ (h >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        capacity *= 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];

        for (MapEntry<K, V> entry : table) {
            if (entry != null) {
                int index = getIndexByKey(entry.key);
                newTable[index] = entry;
            }
        }
        table = newTable;
    }

    private int getIndexByKey(K key) {
        int keyHash = Objects.hashCode(key);
        int mod = hash(keyHash);
        return indexFor(mod);
    }

    private boolean keysMatch(K searchKey, MapEntry<K, V> entry) {
        if (entry == null) {
            return false;
        }

        int searchKeyHash = Objects.hashCode(searchKey);
        int entryKeyHash = Objects.hashCode(entry.key);

        return searchKeyHash == entryKeyHash && Objects.equals(searchKey, entry.key);
    }

    private static class MapEntry<K, V> {
        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}