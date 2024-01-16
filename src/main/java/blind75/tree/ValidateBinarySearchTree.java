package blind75.tree;

import java.util.Stack;

public class ValidateBinarySearchTree {

    public boolean isValidBST2(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> st = new Stack<>();
        TreeNode pre = null;
        while (root != null || !st.isEmpty()) {
            while (root != null) {
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if (pre != null && root.val <= pre.val) return false;
            pre = root;
            root = root.right;
        }
        return true;
    }

    public boolean isValidBST(TreeNode root) {
        // 有效的BST(Binary Search Tree)定义如下：
        //节点的左子树仅包含键小于节点键的节点。
        //节点的右子树只包含键大于节点键的节点。
        //左右子树也必须是二叉搜索树。
        return validBST(root, null, null);
    }

    public boolean validBST(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) return true;

        if (min != null && root.val <= min.val) return false;
        if (max != null && max.val  <= root.val) return false;

        return validBST(root.left, min, root) && validBST(root.right, root, max);
    }

}
