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
    public ListNode doubleIt(ListNode head) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode current = temp;
        while(current!=null){
            if(current.val>=5){
                current.val = (current.val*2)%10;

            } else{
                current.val = current.val*2;
            }
            if(current.next!=null && current.next.val>=5){
                current.val +=1;
            }
            current = current.next;
        }
        if(temp.val == 0){
            return temp.next;
        }
        else{
            return temp;
        }
    }
}