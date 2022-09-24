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
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
         List<Integer> psf = new ArrayList<>(); //path so far
        hasPath(root,targetSum,psf);
        return ans;
    }
    
    public void hasPath(TreeNode root , int sum,List<Integer> psf){
        if(root==null) return;
        psf.add(root.val);
        if(root.left==null&&root.right==null&&sum==root.val) {
            ans.add(new ArrayList<>(psf));
            psf.remove(psf.size()-1);
            return;
        }
        
        hasPath(root.left,sum-root.val,psf);
        hasPath(root.right,sum-root.val,psf);
        psf.remove(psf.size()-1);
        return;
    }
}