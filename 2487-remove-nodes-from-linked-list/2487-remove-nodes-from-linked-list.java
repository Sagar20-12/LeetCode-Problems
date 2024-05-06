/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNodes(ListNode head) {
        Stack<Integer> st = new Stack<>();
        while(head!=null){
            if(st.size() == 0){
                st.push(head.val);
            } else{
                int cur = head.val;
                while(st.size() >0 && st.peek()<cur){
                    st.pop();
                }
                st.push(cur);
            }
            head = head.next;
        }
        ListNode prev = null;
        ListNode cur = null;
        while(st.size() > 0){
            cur = new ListNode(st.pop());
            cur.next = prev;
            prev = cur;
        }
        return cur;
    }
}