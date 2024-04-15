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
    //This is global variable, we havent taken inside the main function because it 
    // will make this value to 0 zero only after iteration
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        getsum(root, 0);
        return sum;
    }
    public void getsum(TreeNode root, int num){
        if(root == null){
            return;
        }
        num = num * 10 + root.val;
        if(root.left == null && root.right == null){
            sum += num;
            return;
        }
        getsum(root.left, num);
        getsum(root.right, num);
    }
}