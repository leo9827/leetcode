package grind75;

public class KthSmallestElementinaBST {

    public int kthSmallest(TreeNode root, int k) {
        // 注意，root 是一个 BST(Binary Search Tree)
        // first step: find the smallest node
        // second step: decrease k to 0
        if (root == null) return 0;
        kth = k;
        smallest = 0;
        smallest(root);

        return smallest;
    }
    public static int kth;
    public static int smallest;
    public void smallest(TreeNode node) {
        if (node.left != null) smallest(node.left); // first step: find the smallest node

        kth--;
        if (kth == 0) { // second step: decrease k to 0
            smallest= node.val;
            return;
        }

        if (node.right != null) smallest(node.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.right = new TreeNode(6);
        TreeNode n3 = new TreeNode(3);
        root.left = n3;
        n3.right = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        n3.left = n2;
        n2.left = new TreeNode(1);
        System.out.println(new KthSmallestElementinaBST().kthSmallest(root, 4));
    }
}
