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
    public int rob(TreeNode root) {
        int[] result = dfs(root);
        return Math.max(result[0], result[1]);
    }

    // returns [skipThis, robThis]
    private int[] dfs(TreeNode node) {
        if (node == null) return new int[]{0, 0};

        int[] left = dfs(node.left);
        int[] right = dfs(node.right);

        // If we rob this node, we cannot rob its children
        int robThis = node.val + left[0] + right[0];

        // If we skip this node, we can choose max of rob/skip for children
        int skipThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{skipThis, robThis};
    }
}
