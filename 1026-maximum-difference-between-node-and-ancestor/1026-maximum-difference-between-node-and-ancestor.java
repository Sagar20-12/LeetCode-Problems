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
    public int maxAncestorDiff(TreeNode root) {
        if (root == null)
            return 0;
        
        int[] result = new int[]{0};
        
        maxVal(root, root.val, root.val, result);
        
        return result[0];
    }

    public void maxVal(TreeNode root, int max, int min, int[] result) {
        if (root == null)
            return;

        result[0] = Math.max(result[0], Math.max(Math.abs(min - root.val), Math.abs(max - root.val)));
        min = Math.min(min, root.val);
        max = Math.max(max, root.val);

        maxVal(root.left, max, min, result);
        maxVal(root.right, max, min, result);
    }
}