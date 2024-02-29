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
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0; 
        while(!queue.isEmpty()){
            int size = queue.size();
            TreeNode prev = null; 
            for(int i=0; i<size; i++){

                //We have to play with level and Node values 
                if(level%2==0){ 
                    if(queue.peek().val%2==0) return false;
                    if(prev != null && prev.val >= queue.peek().val) return false;
                } else{ 
                
                    if(queue.peek().val%2 != 0) return false;
                    if(prev != null && prev.val <= queue.peek().val) return false;
                }

                prev = queue.peek();
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);

                queue.poll(); 
            }
            level++;
        }
        return true;
    }
}