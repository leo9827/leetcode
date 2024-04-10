package neetcode150.linkedlist;

import java.util.Hashtable;

/**
 * <a href="https://leetcode.cn/problems/lru-cache/description/">146. LRU 缓存.</a>
 * 中等
 * 请你设计并实现一个满足  LRU (最近最少使用) 缓存 约束的数据结构。
 * <p>
 * 1 <= capacity <= 3000
 * 0 <= key <= 10000
 * 0 <= value <= 105
 */
class LRUCache2 {
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node[] tb;
    Node head;
    Node tail;
    int capacity;
    int counter;

    public LRUCache2(int capacity) {
        tb = new Node[10001]; // key is 0 <= key <= 10000
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        counter = 0;
        this.capacity = capacity;
    }

    public int get(int key) {
        Node c = tb[key];
        if (c == null) {
            return -1;
        } else {
            delNode(c);
            addNode(c);
            return c.val;
        }
    }

    private void delNode(Node n) {
        n.prev.next = n.next;
        n.next.prev = n.prev;
    }

    private void addNode(Node n) {
        // add node to first
        n.next = head.next;
        head.next.prev = n;
        head.next = n;
        n.prev = head;
    }

    public void put(int key, int value) {
        if (tb[key] != null) {
            Node c = tb[key];
            delNode(c);
            c.val = value;
            addNode(c);
        } else {
            Node n = new Node(key, value);
            if (counter < capacity) {
                counter++;
                tb[key] = n;
                addNode(n);
            } else {
                tb[tail.prev.key] = null;
                delNode(tail.prev);

                tb[key] = n;
                addNode(n);
            }
        }
    }

}

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