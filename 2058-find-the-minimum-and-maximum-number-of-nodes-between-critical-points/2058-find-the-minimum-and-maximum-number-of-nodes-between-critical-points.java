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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        int fcpi = -1;
        int precpi = -1;
        int currentIndex = 1;
        ListNode current = head.next;
        ListNode prev = head;
        int res[] = new int[2];
        res[0] = Integer.MAX_VALUE;
        while(current.next!=null){
            ListNode nextNode = current.next;
            if((current.val<nextNode.val && current.val < prev.val) || 
            (current.val>nextNode.val && current.val > prev.val)){
                if(precpi == -1){
                    fcpi = currentIndex;
                    precpi = currentIndex;
                } else{
                    res[0] = Math.min(res[0], currentIndex - precpi);
                    precpi = currentIndex;
                }
            }
            prev = prev.next;
            current = current.next;
            currentIndex++;
        }
        if(fcpi!=-1 && res[0]!=Integer.MAX_VALUE){
            res[1] = precpi - fcpi;
        } else{
            res[0] = -1;
            res[1] = -1;
        } return res;
    }
}