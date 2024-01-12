package neetcode150.tree;

/**
 * 给你一棵二叉树的根节点，返回该树的 直径 。
 * <p>
 * 二叉树的 直径 是指树中任意两个节点之间最长路径的 长度 。这条路径可能经过也可能不经过根节点 root 。
 * <p>
 * 两节点之间路径的 长度 由它们之间边数表示。
 */
public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        maxDepth(root);
        return max;
    }

    int max = 0;

    private int maxDepth(TreeNode n) {
        if (n == null) return 0;

        int left = maxDepth(n.left);
        int right = maxDepth(n.right);

        max = Math.max(max, left + right);

        return Math.max(left, right) + 1;
    }
}
