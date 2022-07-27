package grind75;

import java.util.Hashtable;

class LRUNode {
    int key;
    int val;
    LRUNode prev;
    LRUNode next;
    LRUNode(int key, int val) {
        this.key = key;
        this.val = val;
    }
}

public class LRUCache {

    int cap, len;
    LRUNode head, tail;
    Hashtable<Integer, LRUNode> table;
    public LRUCache(int capacity) {
        this.cap = capacity;
        this.table = new Hashtable<>(capacity);
        this.len = 0;
        this.head = new LRUNode(-1, 0);
        this.tail = new LRUNode(-1, 0);
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        LRUNode p = find(key);
        if (p != null) {
            remove(p);
            add(p);
            return p.val;
        }
        return -1;
    }
    private void remove(LRUNode p) {
        LRUNode prev = p.prev;
        LRUNode next = p.next;

        prev.next = next;
        next.prev = prev;
        table.remove(p.key);
    }
    private void add(LRUNode p) {
        p.next = head.next;
        p.prev = head;

        head.next = p;
        p.next.prev = p;
        table.put(p.key, p);
    }
    private LRUNode find(int key) {
        if (table.containsKey(key)) {
            return table.get(key);
        }
//        LRUNode p = head;
//        while(p.next!=null) {
//            p = p.next;
//            if (p.key == key) {
//                return p;
//            }
//        }
        return null;
    }

    public void put(int key, int value) {
        LRUNode p = find(key);
        if (p != null) {
            p.val = value;
            remove(p);
            add(p);
        } else {
            p = new LRUNode(key, value);
            add(p);
            len++;
        }
        if (len > cap) {
            LRUNode prevprev = tail.prev.prev;
            table.remove(prevprev.next.key);
            prevprev.next = tail;
            tail.prev = prevprev;
            len--;
        }
    }

    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(1);
        lruCache.put(2, 1);
        System.out.println(lruCache.get(2));
    }
}