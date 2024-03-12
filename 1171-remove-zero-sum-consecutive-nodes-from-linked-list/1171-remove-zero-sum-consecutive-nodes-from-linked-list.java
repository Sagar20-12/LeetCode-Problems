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
    public ListNode removeZeroSumSublists(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int sum = 0;
        for(ListNode n = dummy; n!=null; n = n.next){
            sum+=n.val;
            map.put(sum, n);
        }
        sum = 0;
        for(ListNode n = dummy; n!=null; n = n.next){
            sum+=n.val;
            n.next = map.get(sum).next;
        }
        return dummy.next;
    }
}