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
    int paths = 0;
    public int pathSum(TreeNode root, int k) {
        helper(root,k,new ArrayList<>());
        return paths;
    }
    
    public void helper(TreeNode root , int k,List<Integer> al ){
        if(root==null) return;
        
        al.add(root.val);
      long sum = 0;
        for(int i = al.size()-1 ; i>=0; i--){
            sum+=al.get(i);
            if(sum==k) paths++;
        }
        helper(root.left,k,al);
        helper(root.right,k,al);
        
        
       
        al.remove(al.size()-1);
    }
}