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
        Node current = header;
        Node[] update = new Node[maxHeight + 1]; // 保存每一层的前驱节点, 因为有 maxHeight 高度，所以需要 maxHeight+1 个节点

        for (int i = level; i >= 0; i--) { // 从最高层开始查找,一直到第0层，找到每一层的前驱节点
            while (current.forward[i] != null && current.forward[i].key < key) {
                current = current.forward[i];
            }
            update[i] = current; // 保存每一层(i==level)的前驱节点
        }

        int newHeight = randomHeight(); // 随机生成一个高度给当前 key 节点
        if (newHeight > level) { // 如果新生成的高度大于当前跳表的高度
            for (int i = level + 1; i <= newHeight; i++) { // 那么多出来的高度的前驱节点就是 header
                update[i] = header; // 此时的 i 是多出来的高度
            }
            level = newHeight;
        }

        Node newNode = createNode(key, newHeight); // 给当前 key 生成一个新节点
        for (int i = 0; i <= newHeight; i++) {
            // 将新节点插入到每一层的前驱节点之后
            newNode.forward[i] = update[i].forward[i]; // 将新节点的每一层的 forward 指针指向前驱节点的 forward 指针
            update[i].forward[i] = newNode; // 将新节点插入到每一层的前驱节点之后
        }
    }

    public boolean search(int key) {
        Node current = header; // 使用 header 作为起始节点
        for (int i = level; i >= 0; i--) { // 从当前最高层开始查找
            while (current.forward[i] != null && current.forward[i].key < key) { // 检查当前节点的下一个节点是否为空或者小于 key, 如果小于那么将当前节点移动到下一个节点继续查找
                current = current.forward[i]; // 如果是，那么继续在当前层向后查找, 直到找到一个节点的 key 大于等于 key, 或者是 null, 那么就需要往下一层查找
            }
        }
        // 因为上面的退出条件是 当前节点的下一个节点的key>= key, 所以需要将当前节点移动到下一个节点, 然后判断是否 == key
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


