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
    private List<Integer> arr;
    Solution(){
        this.arr=new ArrayList<>();
    }
    private void inOrder(TreeNode root){
        if(root==null) return;
        inOrder(root.left);
        arr.add(root.val);
        inOrder(root.right);
    } 

    private TreeNode constructTree(int l,int h){
        if(l>h) return null;
        
        int mid=l+(h-l)/2;
        int key=arr.get(mid);
        TreeNode root=new TreeNode(key);
        root.left=constructTree(l,mid-1);
        root.right=constructTree(mid+1,h);
        return root;
    }
    public TreeNode balanceBST(TreeNode root) {
        if(root==null) return root;
        inOrder(root);
        return constructTree(0,arr.size()-1);
    }
}