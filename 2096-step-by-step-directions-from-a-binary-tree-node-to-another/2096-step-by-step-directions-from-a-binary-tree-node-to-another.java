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
    public String getDirections(TreeNode root, int p, int q) {
        TreeNode lca = lca(root,p,q);
        StringBuilder s1 = new StringBuilder("");
        StringBuilder s2 = new StringBuilder("");
        getPath(lca,p,s1);
        getPath(lca,q,s2);
        String ans = "";
        for(int i = 0 ; i < s1.length() ; i++){
           s1.setCharAt(i,'U');
        }
        s2.reverse();
        
        return s1.append(s2).toString();
    }
    
    public boolean getPath(TreeNode root , int dest,StringBuilder sb){
        if(root==null) return false;
        if(root.val==dest) return true;
        
        boolean left = getPath(root.left,dest,sb);
        if(left) {
            sb.append('L');
            return true;
        }
        boolean right = getPath(root.right,dest,sb);
        if(right) {
            sb.append('R');
            return true;
        }
        
        return false;
    }
    
    public TreeNode lca(TreeNode root, int p , int q){
        if(root==null) return null;
        if(root.val==p||root.val==q) {
            return root;
        }
        TreeNode left = lca(root.left,p,q);
        TreeNode right = lca(root.right,p,q);
        if(left==null) {
            return right;
        }
        if(right==null) {
            return left;
        }
        return root;
    }
}