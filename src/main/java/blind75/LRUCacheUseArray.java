package blind75;

class LRUCacheUseArray {
    static class Node {
        int key;
        int value;
        Node next;
        Node prev;

        public Node(int key, int val) {
            this.key = key;
            value = val;
        }
    }

    final int size;
    int used;
    Node head;
    Node tail;
    Node[] map;

    public LRUCacheUseArray(int capacity) {
        size = capacity;
        map = new Node[10_000];
        used = 0;
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = null;
        head.prev = tail;
        tail.next = head;
        tail.prev = null;
    }

    public int get(int key) {
        Node node = map[key];
        if (node == null) {
            return -1;
        }
        putAtBeginning(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map[key];
        if (node != null) {
            node.value = value;
            putAtBeginning(node);
            return;
        }
        createAtBeginning(key, value);
        if (++used > size) {
            map[tail.next.key] = null;
            tail.next.next.prev = tail;
            tail.next = tail.next.next;
        }
    }

    private void createAtBeginning(int key, int value) {
        Node node = new Node(key, value);
        map[key] = node;
        putAtBeginning(node);
    }

    private void putAtBeginning(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        }
        node.prev = head.prev;
        node.prev.next = node;
        node.next = head;
        head.prev = node;
    }

}

