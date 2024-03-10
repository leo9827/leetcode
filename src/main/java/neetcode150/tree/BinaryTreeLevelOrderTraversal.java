package neetcode150.tree;


import java.util.*;

/**
 * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
 * 102. Binary Tree Level Order Traversal
 * Medium
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) return res;
        levelsTravel(res, root, 0);
        return res;
    }

    public void levelsTravel(List<List<Integer>> res, TreeNode root, int level) {
        if (root == null) return;
        if (level >= res.size()) {
            List<Integer> curr = new ArrayList<>();
            curr.add(root.val);
            res.add(curr);
        } else {
            res.get(level).add(root.val);
        }
        levelsTravel(res, root.left, level + 1);
        levelsTravel(res, root.right, level + 1);
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> list = new ArrayList<>();
            if (root==null) return list;
            leveltravel(root, list, 0);
            return list;
        }

        public void leveltravel(TreeNode root, List<List<Integer>> list, int level) {
            if (root==null) return;
            if (list.size()<=level) {
                list.add(new ArrayList<>());
            }
            list.get(level).add(root.val);
            leveltravel(root.left, list, level+1);
            leveltravel(root.right, list, level+1);
        }
    }

    public List<List<Integer>> levelOrder1(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Map<Integer, List<Integer>> levels = new Hashtable<>();
        int level = 0;
        levelTravel(root, level, levels);
        ArrayList<List<Integer>> ret = new ArrayList<>(levels.values());
        Collections.reverse(ret);
        return ret;
    }

    public void levelTravel(TreeNode root, int level, Map<Integer, List<Integer>> levels) {
        if (root == null) return;
        if (!levels.containsKey(level)) levels.put(level, new ArrayList<>());
        levels.get(level).add(root.val);
        levelTravel(root.left, level + 1, levels);
        levelTravel(root.right, level + 1, levels);
    }
}
