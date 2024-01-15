package neetcode150;

import java.util.Random;

public class SkipList {
    public static void main(String[] args) {
        SkipList skipList = new SkipList(4);
        skipList.insert(3);
        skipList.insert(6);
        skipList.insert(7);
        skipList.insert(9);
        skipList.insert(12);
        skipList.insert(19);
        skipList.insert(17);
        skipList.insert(26);
        skipList.insert(21);
        skipList.insert(25);
        skipList.display();

        // 搜索
        int keyToSearch = 19;
        if (skipList.search(keyToSearch)) {
            System.out.println(keyToSearch + " found in the skip list.");
        } else {
            System.out.println(keyToSearch + " not found in the skip list.");
        }
    }

    static class Node {
        int key;
        Node[] forward;

        public Node(int key, int height) {
            this.key = key;
            this.forward = new Node[height + 1];
        }
    }

    private static final double PROBABILITY = 0.5;
    private final Node header;
    private int level;
    private final int maxHeight;

    public SkipList(int maxHeight) {
        this.maxHeight = maxHeight;
        this.level = 0;
        this.header = createNode(Integer.MIN_VALUE, maxHeight);
    }

    private Node createNode(int key, int height) {
        return new Node(key, height);
    }

    private int randomHeight() {
        int height = 1;
        Random rand = new Random();
        while (rand.nextDouble() < PROBABILITY && height < maxHeight) {
            height++;
        }
        return height;
    }

    public void insert(int key) {
        Node[] update = new Node[maxHeight + 1];
        Node current = header;

        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current;
        }

        int newHeight = randomHeight();
        if (newHeight > level) {
            for (int i = level + 1; i <= newHeight; i++) {
                update[i] = header;
            }
            level = newHeight;
        }

        Node newNode = createNode(key, newHeight);
        for (int i = 0; i <= newHeight; i++) {
            newNode.forward[i] = update[i].forward[i];
            update[i].forward[i] = newNode;
        }
    }

    public boolean search(int key) {
        Node current = header;
        for (int i = level; i >= 0; i--) {
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
        }

        current = current.forward[0];
        return current != null && current.key == key;
    }

    public void display() {
        for (int i = level; i >= 0; i--) {
            Node node = header.forward[i];
            System.out.print("Level " + i + ": ");
            while (node != null) {
                System.out.print(node.key + " ");
                node = node.forward[i];
            }
            System.out.println();
        }
    }
}


