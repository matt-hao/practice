package practice.hackTheAlgorithm;

import java.util.HashMap;
import java.util.Map;

public class LruCache {
    int capacity;
    int size;
    CNode dummy;
    CNode tail;
    Map<Integer, CNode> map;

    /*
     * @param capacity: An integer
     */
    public LruCache(int capacity) {
        // do intialization if necessary
        this.capacity = capacity;
        this.size = 0;
        dummy = new CNode(-1);
        tail = dummy;
        map = new HashMap<>();
    }

    /*
     * @param key: An integer
     * @return: An integer
     */
    public int get(int key) {
        // write your code here
        if (!map.containsKey(key))
            return -1;
        int res = -1;
        CNode prev = map.get(key);
        CNode cur = prev.next;
        res = cur.val;
        //cur == tail
        if (cur == tail)
            return res;
        // cur != tail
        prev.next = prev.next.next;
        tail.next = cur;
        cur.next = null;
        map.put(key, tail);
        tail = tail.next;
        return res;
    }

    /*
     * @param key: An integer
     * @param value: An integer
     * @return: nothing
     */
    public void set(int key, int value) {
        // write your code here
        //update
        if (map.containsKey(key)) {
            CNode prev = map.get(key);
            CNode cur = prev.next;
            cur.val = value;
            if (cur == tail)
                return;
            prev.next = prev.next.next;
            tail.next = cur;
            map.put(key, tail);
            tail = tail.next;
            tail.next = null;
        } else {
            //create
            tail.next = new CNode(key, value);
            map.put(key, tail);
            tail = tail.next;
            this.size++;
            if (size > capacity) {
                CNode remove = dummy.next;
                dummy.next = dummy.next.next;
                map.put(dummy.next.key, dummy);
                map.remove(remove.key);
                this.size--;
            }
        }
    }

    public static void main(String[] args) {
        LruCache lruCache = new LruCache(3);
        lruCache.set(1, 1);
        lruCache.set(2, 2);
        lruCache.set(3, 3);
        lruCache.set(4, 4);
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(1));
        lruCache.set(5, 5);
        System.out.println(lruCache.get(1));
        System.out.println(lruCache.get(2));
        System.out.println(lruCache.get(3));
        System.out.println(lruCache.get(4));
        System.out.println(lruCache.get(5));
    }
}

class CNode {
    int key;
    int val;
    CNode next;

    public CNode(int val) {
        this.val = val;
    }

    public CNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}
