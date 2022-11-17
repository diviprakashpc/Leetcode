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
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 class Solution {
	public TreeNode sortedListToBST(ListNode root) {
       
       return helper(root);  
	}
    
    public TreeNode helper(ListNode root){
        if(root==null) return null;
        if(root.next==null) return new TreeNode(root.val);
         ListNode slow = root;
        ListNode fast = root;
        ListNode prev = null;
        while(fast!=null&&fast.next!=null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        TreeNode left = helper(root);
        TreeNode right = helper(slow.next);
        TreeNode r = new TreeNode(slow.val);
        
        r.left = left;
        r.right = right;
        return r;
        
        
    }
}