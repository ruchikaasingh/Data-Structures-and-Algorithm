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
    public boolean isSymmetric(TreeNode root) {
     invert(root.left);
     return checksym(root.left, root.right);   
    }

    public boolean checksym(TreeNode l, TreeNode r){
        if(l==null && r== null) return true;
        if(l==null || r==null) return false;
        if(l.val != r.val ) return false;

        return checksym(l.left, r.left) && checksym(l.right, r.right);
    }

    public static void invert(TreeNode root){
        if(root==null) return;

        TreeNode temp= root.left;
        root.left= root.right;
        root.right= temp;

        invert(root.left);
        invert(root.right);
    }
}