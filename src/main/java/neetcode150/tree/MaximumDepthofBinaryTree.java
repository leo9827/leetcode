package neetcode150.tree;


public class MaximumDepthofBinaryTree {
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;

        int dept = 1;
        int max = Math.max(maxDepth(root.left), maxDepth(root.right));
        return dept + max;
    }
}
