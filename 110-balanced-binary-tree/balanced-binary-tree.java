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
    public boolean isBalanced(TreeNode root) {
        if(root== null) return true;
        int leftLevel= levels(root.left);
        int rightLevel= levels(root.right);

        if(Math.abs(leftLevel- rightLevel)>1) return false;
        return isBalanced(root.left)&& isBalanced(root.right);
    }

    public int levels(TreeNode root){
        if(root==null) return 0;

        int llevel= 1+levels(root.left);
        int rlevel= 1+levels(root.right);

        return Math.max(llevel, rlevel);
    }
}