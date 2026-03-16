/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxDepth = -1;
    private int bottomLeftValue;

    public int findBottomLeftValue(TreeNode root) {
        dfs(root, 0);
        return bottomLeftValue;
    }

    private void dfs(TreeNode node, int depth) {
        if (node == null) return;

        // If this is the first time we reach this depth, record the value
        if (depth > maxDepth) {
            maxDepth = depth;
            bottomLeftValue = node.val;
        }

        // Go left first to ensure leftmost nodes are prioritized
        dfs(node.left, depth + 1);
        dfs(node.right, depth + 1);
    }
}