package practice.hackTheAlgorithm;

import java.util.HashMap;
import java.util.Map;


public class LFUCache {
    public static void main(String[] args) {
        LFUCache lfuCache = new LFUCache(3);
        lfuCache.set(1, 10);
        lfuCache.set(2, 20);
        lfuCache.set(3, 30);
        System.out.println(lfuCache.get(1));
        lfuCache.set(4, 40);
        System.out.println(lfuCache.get(4));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(1));
        lfuCache.set(5, 50);
        System.out.println(lfuCache.get(1));
        System.out.println(lfuCache.get(2));
        System.out.println(lfuCache.get(3));
        System.out.println(lfuCache.get(4));
        System.out.println(lfuCache.get(5));
    }

    private Map<Integer, Integer> map;
    private Map<Integer, MapList> freqMap;
    private int size, minfreq;

    /*
     * @param capacity: An integer
     */
    public LFUCache(int capacity) {
        // do intialization if necessary
        this.size = capacity;
        this.minfreq = 0;
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        if (map.containsKey(key)) {
            getNode(key).val = value;
        } else {
            Node node = new Node(key, value, 0);
            if (this.size == this.map.size()) {
                MapList mapList = freqMap.get(minfreq);
                Node r = mapList.remove();
                map.remove(r.key);
                if (mapList.map.size() == 0) {
                    freqMap.remove(minfreq);
                }
            }
            minfreq = Math.min(minfreq, 0);
            if (!freqMap.containsKey(minfreq)) {
                freqMap.put(minfreq, new MapList());
            }
            freqMap.get(minfreq).set(node);

            map.put(key, 0);
        }
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key))
            return -1;
        return getNode(key).val;
    }

    private Node getNode(int key) {
        int freq = map.get(key);
        MapList mapList = freqMap.get(freq);
        Node node = mapList.get(key);

        node.freq++;
        if (!freqMap.containsKey(node.freq)) {
            freqMap.put(node.freq, new MapList());
        }
        freqMap.get(node.freq).set(node);

        if (freqMap.get(minfreq).map.size() == 0) {
            freqMap.remove(minfreq);
            minfreq = node.freq;
        }
        map.put(key, node.freq);

        return node;
    }

    class MapList {
        Node head, tail;
        Map<Integer, Node> map;

        MapList() {
            this.head = new Node(-1, -1, 0);
            this.tail = head;
            this.map = new HashMap<>();
        }

        public Node get(int key) {
            Node prev = map.get(key);
            Node cur = prev.next;

            prev.next = cur.next;
            if (cur == tail) {
                tail = prev;
            } else {
                map.put(prev.next.key, prev);
            }
            map.remove(key);
            return cur;
        }

        public void set(Node node) {
            map.put(node.key, tail);
            tail.next = node;
            tail = node;
        }

        public Node remove() {
            Node r = head.next;
            head.next = r.next;
            if (r == tail) {
                tail = head;
            } else {
                map.put(r.next.key, head);
            }
            map.remove(r.key);
            return r;
        }
    }

    class Node {
        int key;
        int val;
        int freq;
        Node next;

        public Node(int key, int val, int freq) {
            this.key = key;
            this.val = val;
            this.freq = freq;
        }
    }
}




