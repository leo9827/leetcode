package blind75.tree;

public class LowestCommonAncestorofaBinarySearchTree {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 重要前提：root 是一个 BST（Binary Search Tree）
        if (p.val - root.val > 0 && q.val - root.val > 0) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val - root.val < 0 && q.val - root.val < 0) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;

    }

    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (true) {
            if      (root.val > p.val && root.val > q.val) root = root.left;
            else if (root.val < p.val && root.val < q.val) root = root.right;
            else                                           return root;
        }
    }
}
