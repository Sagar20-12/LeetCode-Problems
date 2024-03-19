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
import java.util.*;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        HashMap<String, List<TreeNode>> map = new HashMap<>();
        return generateTree(1, n, map);
    }

    public static List<TreeNode> generateTree(int start, int end, Map<String, List<TreeNode>> map) {
        String key = start + "-" + end;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        List<TreeNode> trees = new ArrayList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> lefts = generateTree(start, i - 1, map);
            List<TreeNode> rights = generateTree(i + 1, end, map);
            for (TreeNode leftTree : lefts) {
                for (TreeNode rightTree : rights) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftTree;
                    root.right = rightTree;
                    trees.add(root);
                }
            }
        }
        map.put(key, trees);
        return trees;
    }
}
