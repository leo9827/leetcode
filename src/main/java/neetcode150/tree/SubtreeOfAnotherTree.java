package neetcode150.tree;


public class SubtreeOfAnotherTree {
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (isSame(root,subRoot)) return true;
        if (root == null || subRoot == null) return root == subRoot;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean isSame(TreeNode s, TreeNode t) {
        if (s == null || t == null) return s == t;
        if (s.val != t.val) return false;
        return isSame(s.left, t.left) && isSame(s.right, t.right);
    }
}
