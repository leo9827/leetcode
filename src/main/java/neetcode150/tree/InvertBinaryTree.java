package neetcode150.tree;


/**
 * <a href="https://leetcode.com/problems/invert-binary-tree/description/">226. Invert Binary Tree</a>
 * Easy.
 * <p>
 * Given the root of a binary tree, invert the tree, and return its root.
 * <p>
 * Example 1: <p>
 * Input: root = [4,2,7,1,3,6,9] <p>
 * Output: [4,7,2,9,6,3,1] <p>
 * <p>
 * Example 2: <p>
 * Input: root = [2,1,3] <p>
 * Output: [2,3,1] <p>
 * <p>
 * Example 3: <p>
 * Input: root = [] <p>
 * Output: [] <p>
 * <p>
 * Constraints: <p>
 * The number of nodes in the tree is in the range [0, 100]. <p>
 * -100 <= Node.val <= 100
 */
public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null; // 找到终止条件，然后递归交换即可

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTree(root.left);
        invertTree(root.right);

        return root;
    }
}


