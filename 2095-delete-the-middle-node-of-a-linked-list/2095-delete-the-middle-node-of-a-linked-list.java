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
    public ListNode deleteMiddle(ListNode head) {
        if(head.next==null) return null;
        ListNode temp = head;
        ListNode slow = temp;
        ListNode fast = temp;
        ListNode prev = slow;
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        ListNode store = slow.next;
        slow.next = null;
        prev.next =  store;
        
        return head;
        
    }
}