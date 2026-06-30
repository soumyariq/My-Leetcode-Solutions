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
    int ans = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return 0;
        }
        height(root);
        return ans;
    }
    private int height(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int ls = height(node.left);
        int rs = height(node.right);

        ans = Math.max(ans, ls + rs);
        return 1 + Math.max(ls, rs);
    }
}