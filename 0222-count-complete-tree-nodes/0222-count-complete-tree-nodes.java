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
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
      Queue<TreeNode> q = new LinkedList<>();
      q.add(root);
      int ans = 0;
      while(!q.isEmpty()){
        int size = q.size();
        ans+=size;
        if(!isPowerOfTwo(size)) break;
        while(size-->0){
          TreeNode rem = q.remove();
          if(rem.left!=null) q.add(rem.left);
          if(rem.right!=null) q.add(rem.right);
        }
      }
      
      return ans;
    }
  
  public boolean isPowerOfTwo(int n){
     return (n&(n-1))==0;
  }
}