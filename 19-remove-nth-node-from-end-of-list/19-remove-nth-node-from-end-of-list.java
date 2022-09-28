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
       if(head==null||head.next==null) return null;
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        for(int i = 1 ; i < n ; i++) fast = fast.next;
        
        while(fast!=null&&fast.next!=null){
          prev = slow;
          slow = slow.next;
          fast = fast.next;
        }
        if(slow==head) return head.next;
          prev.next = slow.next;
         slow.next = null;
         return head;
    }
}