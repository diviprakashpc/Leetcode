/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Node d1 = head;
        while(d1!=null){
            Node n = new Node(d1.val);
            Node temp = d1.next;
            d1.next = n;
            n.next = temp;
            d1 = d1.next.next;
        }
         d1 = head;
        while(d1!=null){
            Node rand = d1.random;
            if(rand!=null) d1.next.random = rand.next;
            else d1.next.random = null;
            d1 = d1.next.next;
        }
        
         d1  = head;
        Node d2 = head.next;
        Node ans = d2;
        while(d1!=null&&d2!=null){
            d1.next = d1.next.next;
            if(d2.next!=null)
            d2.next = d2.next.next;
            d1 = d1.next;
            d2 = d2.next;
        }
        
        return ans;
        
    }
}