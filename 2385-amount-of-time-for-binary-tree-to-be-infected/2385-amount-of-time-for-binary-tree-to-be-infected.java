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
    // Start with forming recursive approach to the problem
    // make the parameters
    private int result;
    public int amountOfTime(TreeNode root, int start) {
        dfs(root, start);
        return result;

    }
    private int dfs(TreeNode node, int start){
        if(node == null)
            return 0;
        int leftNode = dfs(node.left, start);
        int rightNode = dfs(node.right, start);
        if(node.val == start){
            result = Math.max(leftNode, rightNode); //
            return -1; 

        } else if(leftNode >= 0 && rightNode >= 0)
            return Math.max(rightNode, leftNode) + 1; //
        result = Math.max(result, Math.abs(leftNode - rightNode));
        return Math.min(leftNode, rightNode) - 1; //

    }
}