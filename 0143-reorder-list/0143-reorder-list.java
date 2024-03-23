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

// 1. Get the middle element;
// 2. Reverse the second half; (make reverse function and call the function using reverse(mid))
// 3. Merge the second half

class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null)
            return;
        ListNode mid = getmid(head);
        ListNode rev = reverse(mid);
        mid.next = null;
        reorderList(head, rev);
    }
    private ListNode getmid(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    private ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode current = head;
        ListNode next;
        while(current!=null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;
    }
    private ListNode reorderList(ListNode head, ListNode head2){
        ListNode originalhead = head;
        while(head!=null && head2!=null){
            ListNode temp = head.next;
            ListNode temp1 = head2.next;
            head.next = head2;
            head2.next = temp;
            head = temp;
            head2 = temp1;
        }
        return originalhead;
    }
}