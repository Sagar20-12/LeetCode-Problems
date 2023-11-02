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
    int result = 0;
    public int averageOfSubtree(TreeNode root) {
        helper(root);
        return result;
    }
    private int[] helper(TreeNode node){
        if(node == null){
            return new int[]{0,0};
        }
        int[] left = helper(node.left);
        int[] right = helper(node.right);
        int currentSum = left[0] + right[0] + node.val;
        int currentCount = left[1] + right[1] + 1;
        if(currentSum/currentCount == node.val){
            result+=1;
        }
        return new int[]{currentSum, currentCount};
    }
}