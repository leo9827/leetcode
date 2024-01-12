package neetcode150.tree;

public class CountGoodNodesInBinaryTree {
    int good = 0;

    public int goodNodes(TreeNode root) {
        if (root == null) return good;
        travel(root, root.val);
        return good;
    }
    private void travel(TreeNode n, int max) {
        if (n == null) return;
        if (n.val >= max) good++;
        max = Math.max(max, n.val);
        travel(n.left, max);
        travel(n.right, max);
    }
}
