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
    public int sumNumbers(TreeNode root) {
        ArrayList<Integer> numbers = new ArrayList<>();
        collectNumbers(root, 0, numbers);

        int sum = 0;
        for (int num : numbers) sum += num;
        return sum;
    }

    private void collectNumbers(TreeNode node, int current, ArrayList<Integer> numbers) {
        if (node == null) return;
        
        current = current * 10 + node.val;
        if (node.left == null && node.right == null) {
            numbers.add(current);
            return;
        }
        collectNumbers(node.left, current, numbers);
        collectNumbers(node.right, current, numbers);
    }
}