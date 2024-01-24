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

 // We can use DFS in the following question
/* class Solution {
    int result = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        
        Set<Integer> set = new HashSet<>();
        dfs(root, set);
        return result;
    }
    private void dfs(TreeNode root, Set<Integer> set){
        if(root == null)
            return;
        if(set.contains(root.val)){
            set.remove(root.val);
        } else{
            set.add(root.val);
        }
        if(root.left == null && root.right == null){
            if(set.size()<=1)
                result++;
        }
        dfs(root.left, new HashSet(set));
        dfs(root.right, new HashSet(set));
    }
} */

class Solution{
    int result = 0;
    int num[];
    public int pseudoPalindromicPaths(TreeNode root){
        num = new int[10];
        dfs(root);
        return result;
    }
    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        num[root.val]++;
        if(root.left == null && root.right == null){
            if(Palindrome()){
                result++;

            }
        }
        else{
            dfs(root.left);
            dfs(root.right);
        }
        num[root.val]--;
    }
    private boolean Palindrome(){
        int odd = 0;
        for(int i = 0; i<=9; i++){
            if(num[i]%2!=0){
                odd++;
            }
        }
        if(odd>1){
            return false;
        }
        return true;
    }
}