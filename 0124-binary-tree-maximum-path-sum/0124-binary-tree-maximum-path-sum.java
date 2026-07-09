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
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return maxSum;
    }
    private int maxSum = Integer.MIN_VALUE;
    private int dfs(TreeNode root) {
        if (root == null) return 0;
        int leftMax = Math.max(dfs(root.left), 0);
        int rightMax = Math.max(dfs(root.right), 0);
        int newPathPrice = root.val + leftMax + rightMax;
        maxSum = Math.max(maxSum, newPathPrice);
        return root.val + Math.max(leftMax, rightMax);
    }
}