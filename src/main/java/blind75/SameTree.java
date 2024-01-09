package blind75;

public class SameTree {
    public boolean isSameTree(TreeNode left, TreeNode right) {
        if (left == null || right == null) return (left == right);
        if (left.val == right.val) return isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
        return false;
    }
}
