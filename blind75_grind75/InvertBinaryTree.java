package grind75;


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


