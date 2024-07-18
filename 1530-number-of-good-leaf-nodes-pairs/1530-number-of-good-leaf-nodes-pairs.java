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
    // Declare a global variable count
    private int count = 0;
    
    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }

    public List<Integer> dfs(TreeNode root, int distance) {
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            List<Integer> dist = new ArrayList<>();
            dist.add(1);
            return dist;
        }
        List<Integer> left = dfs(root.left, distance);
        List<Integer> right = dfs(root.right, distance);
        for (int l : left) {
            for (int r : right) {
                int finalDist = l + r;
                if (finalDist <= distance) {
                    count++;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int l : left) {
            result.add(l + 1);
        }
        for (int r : right) {
            result.add(r + 1);
        }
        return result;
    }
}
