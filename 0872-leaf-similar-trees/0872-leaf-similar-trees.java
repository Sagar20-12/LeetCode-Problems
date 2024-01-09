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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root1, leaf1);
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }
    
    // Recursive dfs approach. We will sort this out in the interview with clarity
    public void dfs(TreeNode node, List<Integer> leaf){
        if(node == null)
            return;
        if(node.left == null && node.right == null){
            leaf.add(node.val);
            return;
        }
        dfs(node.left, leaf);
        dfs(node.right, leaf);
    }
}