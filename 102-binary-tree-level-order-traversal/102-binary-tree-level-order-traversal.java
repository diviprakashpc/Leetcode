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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        Queue<TreeNode> q=  new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size();
            List<Integer> al = new ArrayList<>();
            while(size-->0){
                TreeNode front = q.remove();
                al.add(front.val);
                if(front.left!=null) q.add(front.left);
                if(front.right!=null) q.add(front.right);
            }
            ans.add(al);
        }
        return ans;
    }
}