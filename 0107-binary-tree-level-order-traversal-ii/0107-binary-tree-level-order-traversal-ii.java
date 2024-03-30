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
// class Solution {
//     public List<List<Integer>> levelOrderBottom(TreeNode root) {
//         List<List<Integer>> list = new LinkedList<>();
//         Queue<TreeNode> q = new LinkedList<>();
//         if(root == null){
//             return list;
//         }
//         q.offer(root);
//         while(!q.isEmpty()){
//             int levelSize = q.size();
//             List<Integer> finallist = new LinkedList<Integer>();
//             for(int i = 0; i<levelSize; i++){
//                 if(root.left!=null){
//                     q.offer(root.left);
//                 }
//                 if(root.right!=null){
//                     q.offer(root.right);
//                 }
//                 finallist.add(q.poll().val);
//             }
//             list.add(0, new LinkedList<>(finallist));
//         }
//         return list;
//     }
// }

//BFS Solution
public class Solution{
    public List<List<Integer>> levelOrderBottom(TreeNode root){
        List<List<Integer>> list = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root == null)
        return list;
        q.add(root);
        while(!q.isEmpty()){
            // we created a new list and the list size is the q size
            List<Integer> finallist = new ArrayList<>();
            int levelSize = q.size();
            for(int i = 0; i<levelSize; i++){
                TreeNode node = q.poll();
                finallist.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            // printing the list in reverse order
            list.add(0, finallist);

        }
        return list;
    }
}