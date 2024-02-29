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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        ListNode slow = head;
        //Move the fast pointer N nodes ahead of slow pointer
        for(int i = 0; i<n; i++)
            fast = fast.next;
    //If fast reaches the end i.e Null return head.next
        if(fast == null)
            return head.next;
        while(fast.next!=null){
            fast = fast.next;
            slow = slow.next;
        }
        ListNode deleteNode = slow.next;
        slow.next = slow.next.next;
        return head;
    }
}