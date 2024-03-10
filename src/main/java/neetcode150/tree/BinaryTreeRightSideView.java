package neetcode150.tree;

import java.util.*;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Example 1:
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * Example 2:
 * Input: root = [1,null,3]
 * Output: [1,3]
 * <p>
 * Example 3:
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class BinaryTreeRightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        if (root  == null) return Collections.emptyList();
        return rightSideViewUsingDepthTravel(root);
    }

    private List<Integer> rightSideViewUsingDepthTravel(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root  == null) return res;
        depthTravel(root,res, 0);
        return res;
    }

    private void depthTravel(TreeNode root, List<Integer> res, int depth) {
        if (root == null) return;

        if (res.size() == depth) {
            res.add(root.val); // add every depth first node
        }

        depthTravel(root.right, res, depth+1);
        depthTravel(root.left,  res, depth+1);
    }


    static class Solution {
        private List<Integer> rightSideViewUsingBFS(TreeNode root) {
            List<Integer> res = new ArrayList<>();
            if (root  == null) return res;
    //        利用 BFS 进行层次遍历，记录下每层的最后一个元素。
            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);
            while(!q.isEmpty()) {
                int size = q.size(); // 每层左右左右这样放进去
                for (int i=0; i < size; i++) {
                    TreeNode cur = q.poll();
                    if (cur.left != null) q.offer(cur.left);
                    if (cur.right != null) q.offer(cur.right);
                    if (i == size-1) res.add(cur.val); // 每层的最后一个元素。
                }
            }
            return res;
        }
    }

    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideViewUsingDFS(TreeNode root) {
        dfs(root, 0);
        return res;
    }
    private void dfs(TreeNode n, int depth) {
        if (n == null) return;
        if (res.size() == depth) res.add(n.val);
        depth++;
        dfs(n.right, depth);
        dfs(n.left, depth);
    }
}
