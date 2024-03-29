package neetcode150.tree;

/*
Given a binary tree, determine if it is height-balanced.
>一棵高度平衡二叉树定义为：
>一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。

Example 1:
Input: root = [3,9,20,null,null,15,7]
Output: true

Example 2:
Input: root = [1,2,2,3,3,null,null,4,4]
Output: false

Example 3:
Input: root = []
Output: true

Constraints:
The number of nodes in the tree is in the range [0, 5000].
-104 <= Node.val <= 104
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {
        return isBalancedTopToBottom(root);
    }

    public int height(TreeNode root) {
        if (root == null) return 0;
        return Math.max(height(root.left), height(root)) + 1;
    }

    public boolean isBalancedTopToBottom(TreeNode root) {
        if (root == null) return true;
        return Math.abs(height(root.left) - height(root.right)) <= 1 &&
                isBalanced(root.left) &&
                isBalanced(root.right);
    }

    public boolean isBalancedBottomToTop(TreeNode root) {
        if (root == null) return true;
        return depth(root) > 0;
    }

    private int depth(TreeNode root) {
        if (root == null) return 0;
        int left = depth(root.left);
        int right = depth(root.right);
        if (left < 0 || right < 0 || Math.abs(left - right) > 1) return -1;
        return Math.max(left, right) + 1;
    }
}
