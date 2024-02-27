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
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return maxD;
    }
    int maxD = 0;
    public int dfs(TreeNode node){
        if(node == null)
            return 0;
        int left = dfs(node.left);
        int right = dfs(node.right);
        maxD = Math.max(maxD, left + right);
        return Math.max(left, right) + 1;
    }
}
