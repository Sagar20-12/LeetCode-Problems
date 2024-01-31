/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
/* Brute force approach

public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode temp = head;
        Map<ListNode, Integer> np = new HashMap<>();
        while(temp!=null){
            if(np.containsKey(temp)){
                return true;
            }
            np.put(temp, 1);
            temp = temp.next;
        }
        return false;
    }
}
*/

//Optimal code using fast and slow pointer

public class Solution{
    public boolean hasCycle(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                return true;
            }
        }
        return false;
    }
}