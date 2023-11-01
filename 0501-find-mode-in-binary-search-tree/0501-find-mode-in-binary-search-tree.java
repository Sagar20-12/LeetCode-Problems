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
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        inorder(root, map);
        List<Integer> res = new ArrayList();
        for(int key : map.keySet()){
            if(map.get(key) == max){
                res.add(key);
            }
        }
        int[] result = new int[res.size()];
        for(int i = 0; i<res.size(); i++){
            result[i] = res.get(i);
        }
        return result;
    }
    int max = 0;
    public void inorder(TreeNode root, HashMap<Integer, Integer> res){
        if(root == null) 
            return;
        inorder(root.left, res);
        res.put(root.val, res.getOrDefault(root.val, 0) + 1); //to find the value mapped to the specified key
        max = Math.max(max, res.get(root.val));
        inorder(root.right, res);
    }
}