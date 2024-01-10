package neetcode150;

import java.util.HashMap;
import java.util.Map;

/*
 A linked list of length n is given such that each node contains an additional random pointer,
 which could point to any node in the list, or null.

 Construct a deep copy of the list. The deep copy should consist of exactly n brand new nodes,
 where each new node has its value set to the value of its corresponding original node.
 Both the next and random pointer of the new nodes should point to new nodes in the copied list
 such that the pointers in the original list and copied list represent the same list state.
 None of the pointers in the new list should point to nodes in the original list.

 For example, if there are two nodes X and Y in the original list, where X.random --> Y,
 then for the corresponding two nodes x and y in the copied list, x.random --> y.

 Return the head of the copied linked list.

 The linked list is represented in the input/output as a list of n nodes. Each node is represented as a pair of [val,
 random_index] where:

 val: an integer representing Node.val
 random_index: the index of the node (range from 0 to n-1) that the random pointer points to,
 or null if it does not point to any node.
 Your code will only be given the head of the original linked list.

 Example1
 Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

 Example2
 Input: head = [[1,1],[2,1]]
 Output: [[1,1],[2,1]]
 */
public class CopyListwithRandomPointer {

    public Node copyRandomList(Node head) {
        Map<Node, Node> cache = new HashMap<>();
        Node l = head;
        while (l !=null) {
            cache.put(l, new Node(l.val));
            l = l.next;
        }

        Node r = head;
        while(r != null) {
            cache.get(r).next = cache.get(r.next);
            cache.get(r).random = cache.get(r.random);
            r = r.next;
        }
        return cache.get(head);
    }


    Map<Node, Node> m1 = new HashMap<>();
    public Node copyRandomList2(Node head) {
        if (head == null) return null;
        if (m1.containsKey(head)) return m1.get(head);
        Node root = new Node(head.val);
        m1.put(head, root);
        root.next = copyRandomList2(head.next);
        root.random = copyRandomList2(head.random);
        return root;
    }

}
