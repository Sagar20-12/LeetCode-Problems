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
    int total = 0;
    public int distributeCoins(TreeNode root) {
        solvedfs(root);
        return total;
    }
    public int solvedfs(TreeNode root){
        if(root == null)
            return 0;
        int finalCoins = solvedfs(root.left) + solvedfs(root.right) + root.val - 1;
        total += Math.abs(finalCoins);
        return finalCoins;
    }
}