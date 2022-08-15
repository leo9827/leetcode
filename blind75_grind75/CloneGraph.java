package grind75;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    public static void main(String[] args) {

    }
    Map<Integer, Node> nodes = new HashMap<>();
    public Node cloneGraph(Node node) {
        if (node == null) return null;

        if (nodes.containsKey(node.val)) return nodes.get(node.val);
        // 1 创建所有的node

        Node newNode = new Node(node.val);
        nodes.put(node.val, newNode);
        if (node.neighbors !=null) {
            newNode.neighbors = new ArrayList<>();
            // 2 连接他们
            for (Node neighbor : node.neighbors) {
                Node nb = cloneGraph(neighbor);
                newNode.neighbors.add(nb);
            }
        }
        nodes.put(node.val, newNode);
        return newNode;
    }



}


// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
