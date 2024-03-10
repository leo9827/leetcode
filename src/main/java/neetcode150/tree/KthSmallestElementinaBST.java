package neetcode150.tree;

/**
 * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
 * 230. Kth Smallest Element in a BST
 * Medium
 */
public class KthSmallestElementinaBST {
    static int kth;
    static int smallest;
    public int kthSmallest(TreeNode root, int k) {
        if (root==null) return 0;
    
        return smallest;
    }
    
    public void smallest(TreeNode root) {
        if (root.left!=null) smallest(root.left);
        kth--;
        if(kth==0) {
            smallest=root.val;
            return;
        }
        if (root.right!=null) smallest(root.right);
    }
}
