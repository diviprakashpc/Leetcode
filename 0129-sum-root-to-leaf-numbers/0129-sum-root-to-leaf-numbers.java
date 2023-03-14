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
    int sum;
    public int sumNumbers(TreeNode root) {
        sum = 0;
        dfs(root,root.val);
        return sum;
    }

    public void dfs(TreeNode root , int n){
       if(root==null) return;
       if(root.left==null&&root.right==null){
           System.out.println(n);
           sum+=n;
           return;
       }
       if(root.left!=null){
           dfs(root.left,n*10 + root.left.val);
       }
       if(root.right!=null){
           dfs(root.right,n*10 + root.right.val);
       }
       return;
    }
}