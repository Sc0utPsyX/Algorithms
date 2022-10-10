
package lesson_8;

import java.util.Objects;

public class HashTableImpl <K, V> implements HashTable<K, V>{
    private final Item<K, V>[] data;
    private final Item<K, V> emptyItem;
    private int size;

    static class Item<K, V> implements Entry<K, V> {
        private final K key;
        private V value;

        private Item<K, V> nextItem;

        Item(K key, V value) {
            this.key = key;
            this.value = value;
            this.nextItem = null;
        }

        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        public Item<K, V> getNextItem() {
            if (nextItem == null){
                return null;
            }
            return nextItem;
        }
        public void setNextItem(Item<K, V> item){
            this.nextItem = item;
        }

        @Override
        public void setValue(V value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return String.format("key: %s -> value: %s", key, value);
        }
    }


    public HashTableImpl(int initialCapacity) {
        this.data = new Item[initialCapacity * 2];
        emptyItem = new Item<>(null, null);
    }

    public HashTableImpl() {
        this(16);
    }

        @Override
    public boolean put(K key, V value) {
        if (size() == data.length) {
            return false;
        }

        int indexFromHashFunc = hashFunc(key);
        if (data[indexFromHashFunc] == null) {
            data[indexFromHashFunc] = new Item<>(key, value);
            size++;
            return true;
        }
        Item<K, V> item = data[indexFromHashFunc];
        while (item.nextItem != null) {
            item = item.nextItem;
        }
        item.nextItem = new Item<>(key, value);
        size++;
        return true;
    }

    private int getDoubleHash(K key) {
        int n = data.length / 2;
        return n - (key.hashCode() % n);
    }

    private boolean isKeysEquals(Item<K, V> item, K key) {
        if (item == emptyItem) {
            return false;
        }
        if (item.getKey() == null) return key == null;
        return item.getKey().equals(key);
    }

    private int hashFunc(K key) {
        return Math.abs(key.hashCode() % data.length);
    }

    @Override
    public V get(K key) {
        Item<K, V> index = indexOf(key);
        if (index == null) return null;
        return index.getValue();
    }

    private Item<K, V> indexOf(K key) {
        int indexFromHashFunc = hashFunc(key);
            if (data[indexFromHashFunc] == null) {
                return emptyItem;
            }
            if (isKeysEquals(data[indexFromHashFunc], key)) {
                return data[indexFromHashFunc];
            }
            Item<K, V> index = data[indexFromHashFunc];
            while (!isKeysEquals(index, key)){
                if (index.nextItem == null) return null;
                index = index.getNextItem();
            }
            return index;
    }

    @Override
    public V remove(K key) {
        int indexFromHashFunc = hashFunc(key);
        if (data[indexFromHashFunc] == null) {
            size--;
            return null;
        }
        Item<K, V> removed = data[indexFromHashFunc];
        if (removed.getKey().equals(key)){
            if(removed.nextItem == null) {
                size--;
                data[indexFromHashFunc] = null;
            } else {
                data[indexFromHashFunc] = removed.nextItem;
                size--;
                return removed.getValue();
            }
        }
        Item<K, V> beforeRemoved = removed;
        while(!removed.getKey().equals(key)){
            beforeRemoved = removed;
            if(removed.nextItem != null){
                removed = removed.nextItem;
            } else return null;
        }
        if (removed.nextItem == null){
            beforeRemoved.nextItem = null;
        } else {
            beforeRemoved.nextItem = removed.nextItem;
        }
        size--;
        return removed.getValue();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void display() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < data.length; i++) {
            Item<K, V> item = data[i];
            if (item == null) {
            } else {
            do {
                sb.append(String.format("Array index %s = [%s]%n", i, item));
                if (item.nextItem == null){
                    break;
                }
                item = item.nextItem;
            } while (true);
        }
        }
        return sb.toString();
    }
}
