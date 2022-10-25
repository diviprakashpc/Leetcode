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
    public ListNode reverseKGroup(ListNode head, int k) {
         
      if(head==null||head.next==null||k==1) return head;
      ListNode end = head;
      ListNode dummy = new ListNode(-1); //beforeStart;
      dummy.next = head;
      ListNode bS = dummy;
      int i = 0;
      while(end!=null){
         i++;
         if(i%k==0){
            ListNode aE = end.next;//afterEnd;
            ListNode start = bS.next;
            reverse(start,end);
            bS.next = end;
            start.next = aE;
            bS = start;
            end = aE;
         }else{
           end = end.next;
         }
      }
      return dummy.next;
    }
    
    public void reverse(ListNode start,ListNode end){
        ListNode prev = null;
        ListNode curr = start;
        ListNode n = curr.next;
        while(prev!=end){
          curr.next = prev;
          prev = curr;
          curr = n;
          n = (curr!=null)?curr.next:null;
        }
    }
}