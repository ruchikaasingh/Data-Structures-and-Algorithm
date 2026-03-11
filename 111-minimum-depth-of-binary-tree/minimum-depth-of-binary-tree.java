class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        // If leaf node
        if (root.left == null && root.right == null) {
            return 1;
        }

        int leftTree = Integer.MAX_VALUE;
        int rightTree = Integer.MAX_VALUE;

        if (root.left != null) {
            leftTree = minDepth(root.left);
        }
        if (root.right != null) {
            rightTree = minDepth(root.right);
        }

        return 1 + Math.min(leftTree, rightTree);
    }
}