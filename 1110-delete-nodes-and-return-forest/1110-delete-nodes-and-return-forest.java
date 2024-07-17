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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        HashSet<Integer> set = new HashSet<>();
        for(int del : to_delete){
            set.add(del);
        }
        List<TreeNode> forest = new ArrayList<>();
        root = dfs(root, set, forest);
        if(root!=null){
            forest.add(root);
        }
        return forest;
        
    }
    public TreeNode dfs(TreeNode root, HashSet<Integer> to_delete, List<TreeNode> forest){
        if(root == null){
            return root;
        }
        root.left = dfs(root.left, to_delete, forest);
        root.right = dfs(root.right,to_delete, forest);

        //processing the root
        if(!to_delete.contains(root.val)){
            return root;
        }
        if(root.left!=null){
            forest.add(root.left);
        }
        if(root.right!=null){
            forest.add(root.right);
        }
        root.left = null;
        root.right = null;
        return  null;
    }
}