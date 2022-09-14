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
    int ans = 0;
    public int pseudoPalindromicPaths (TreeNode root) {
        int[] freq = new int[9];
        freq[root.val-1]++;
        helper(root,freq);    
        return ans;
    }            
    
    public void helper(TreeNode root , int[] freq){
        if(root==null) return;
        if(root.left==null&&root.right==null){
            int atmostOne = 0;
            for(int i =0  ; i < 9 ;i++){
                if(freq[i]%2!=0) atmostOne++;
            }
            if(atmostOne<=1) ans++;
            return;
        }
        
        if(root.left!=null){
            freq[root.left.val-1]++;
            helper(root.left,freq);
            freq[root.left.val-1]--;
        }
        
        if(root.right!=null){
            freq[root.right.val-1]++;
             helper(root.right,freq);
            freq[root.right.val-1]--;
        }
       
    }
}