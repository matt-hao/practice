package interview.wePay.oa;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * implement hashtable
 * @param <K>
 * @param <V>
 */
public class ImplementHashTable<K, V> {
    private int capacity;
    private int size;

    private LinkedList<Entry<K, V>>[] arr;

    public ImplementHashTable() {
        this.capacity = 16;
        this.size = 0;
        this.arr = new LinkedList[capacity];
    }

    class Entry<K, V> {
        K key;
        V value;

        Entry(K k, V v) {
            this.key = k;
            this.value = v;
        }
    }

    public synchronized void put(K key, V value) {
        if (key == null)
            throw new NullPointerException("Key cannot be null");
        int index = hashcode(key.hashCode());
        if (arr[index] == null) {
            arr[index] = new LinkedList<>();
        }

        LinkedList<Entry<K, V>> list = arr[index];
        Iterator<Entry<K, V>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            //key already exists, value is updated.
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        //key doesn't exist yet
        list.add(new Entry<>(key, value));
        size++;

        if (size > capacity / 2) {
            //rehashing
            rehashing();
        }
    }

    public V get(K key) {
        if (key == null) {
            throw new NullPointerException("key cannot be null!");
        }

        int index = hashcode(key.hashCode());
        if (arr[index] == null) {
            return null;
        }
        LinkedList<Entry<K, V>> list = arr[index];
        Iterator<Entry<K, V>> iterator = list.iterator();
        while (iterator.hasNext()) {
            Entry<K, V> entry = iterator.next();
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }

    private void rehashing() {
        capacity *= 2;
        LinkedList<Entry<K, V>>[] nArr = new LinkedList[capacity];
        for (LinkedList<Entry<K, V>> l : arr) {
            if (l == null)
                continue;
            for (Entry<K, V> e : l) {
                hashLocate(e, nArr);
            }
        }
        arr = nArr;
    }

    private int hashcode(int keyCode) {
        int hashCode;
        if (keyCode < 0) {
            hashCode = (keyCode % capacity + capacity) % capacity;
        } else {
            hashCode = keyCode % capacity;
        }
        return hashCode;
    }

    private void hashLocate(Entry<K, V> entry, LinkedList<Entry<K, V>>[] nArr) {
        int nKey = hashcode(entry.key.hashCode());
        if (nArr[nKey] == null) {
            nArr[nKey] = new LinkedList<>();
        }
        LinkedList<Entry<K, V>> list = nArr[nKey];
        list.addFirst(entry);
    }


    public static void main(String[] args) {
        ImplementHashTable<Integer, Integer> map = new ImplementHashTable<>();
        System.out.println(map.get(1));//null
        map.put(1, 1);
        map.put(1, 2);
        map.put(2, 2);
        System.out.println(map.get(1));//2
        System.out.println(map.get(2));//2

        System.out.println("=====================================");

        ImplementHashTable<String, String> map1 = new ImplementHashTable<>();
        map1.put("a", "a");
        map1.put("b", "b");
        map1.put("c", "a");
        map1.put("d", "d");
        map1.put("e", "d");
        map1.put("f", "d");
        System.out.println(map1.capacity);//16
        map1.put("g", "d");
        map1.put("h", "d");
        map1.put("i", "d");
        map1.put("j", "d");
        map1.put("k", "d");
        map1.put("l", "d");
        System.out.println(map1.capacity);//32
        map1.put("m", "d");
        map1.put("n", "d");
        map1.put("o", "d");
        map1.put("p", "d");//grow
        map1.put("q", "d");
        map1.put("r", "d");
        map1.put("s", "d");
        map1.put("t", "d");
        System.out.println(map1.capacity);//64
        map1.put("u", "d");
        map1.put("v", "d");
        map1.put("w", "d");
        map1.put("x", "d");
        map1.put("y", "d");
        map1.put("z", "d");
        System.out.println(map1.get("a"));//a
        System.out.println(map1.get("b"));//b
        System.out.println(map1.get("c"));//a
        System.out.println(map1.get("d"));//d
        System.out.println(map1.capacity);
    }
}
