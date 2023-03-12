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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ans = new ListNode((int)-1e5,null);
        ListNode head = ans;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode n : lists) {
            if(n!=null) pq.add(n);
        }
        while(!pq.isEmpty()){
            ListNode ptr = pq.remove();
            ListNode n = new ListNode(ptr.val,null);
            head.next = n;
            head = head.next;
            ptr = ptr.next;
            if(ptr!=null) pq.add(ptr);
        }
        
        return ans.next;
    }
}