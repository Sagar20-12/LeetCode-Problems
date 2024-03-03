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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> wrapList = new ArrayList<>();
        if (root == null) return wrapList;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean flag = true;
        //0 means left to right
        //1 means right to left
        

        while (!queue.isEmpty()) {
            int levelNum = queue.size();
            List<Integer> subList = new ArrayList<>(levelNum);

            for (int i = 0; i < levelNum; i++) {
                TreeNode node = queue.poll();

                if (flag) {
                    subList.add(node.val);
                } else {
                    subList.add(0, node.val);
                }

                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }

            flag = !flag;
            wrapList.add(subList);
        }

        return wrapList;
    }
}
