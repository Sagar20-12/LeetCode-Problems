/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
 /* public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // writing the base case condition
        if(headA == null || headB == null)
            return null;
        ListNode intersection1 = headA;
        ListNode intersection2 = headB;
        while(intersection1!=intersection2){
            if(intersection1 == null){
                intersection1 = headB;
            } else {
                intersection1 = headA.next;
            }
            if(intersection2 == null){
                intersection2 = headA;

            } else{
                intersection2 = headB.next;
            }
        }
        return intersection1;
    }
} */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Check for base cases
        if (headA == null || headB == null)
            return null;

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        return pointerA;
    }
}
