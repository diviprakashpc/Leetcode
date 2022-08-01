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
    public void reorderList(ListNode head) {
         if(head==null||head.next==null) return;
            
            
            ListNode slow=head;
            ListNode fast=head;
            while(fast.next!=null&&fast.next.next!=null){ 
                slow=slow.next;
                fast=fast.next.next;
            }
            
            
            ListNode prev=slow;
            ListNode nex=slow.next;
            while(nex.next!=null){
                ListNode current=nex.next;
                nex.next=current.next;
                current.next=prev.next;
                prev.next=current;
            }
            
           
            ListNode d1=head;
            ListNode d2=prev.next;
            while(d1!=prev){
                prev.next=d2.next;
                d2.next=d1.next;
                d1.next=d2;
                d1=d2.next;
                d2=prev.next;
            }
    }
}