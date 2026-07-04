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
    public String getDirections(TreeNode root, int startValue, int destValue) {
        StringBuilder startPath = new StringBuilder();
        StringBuilder destPath = new StringBuilder();
        dfs(root, startValue, startPath);
        dfs(root, destValue, destPath);
        int i = 0;
        while (i < Math.min(startPath.length(), destPath.length())) {
            if (startPath.charAt(i) != destPath.charAt(i)) {
                break;
            }
            i++;
        }
        StringBuilder ans = new StringBuilder();
        for (int j = i; j < startPath.length(); j++) {
            ans.append('U');
        }
        ans.append(destPath.substring(i));
        return ans.toString();
    }
    private boolean dfs(TreeNode node, int target, StringBuilder path) {
        if (node == null) {
            return false;
        }
        if (node.val == target) {
            return true;
        }
        path.append('L');
        if (dfs(node.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        path.append('R');
        if (dfs(node.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        return false;
    }
}