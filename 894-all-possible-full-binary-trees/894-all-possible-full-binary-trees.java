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
    public List<TreeNode> allPossibleFBT(int n) {
         if(n==0) return new ArrayList<>();
         if(n==1) {
             List<TreeNode> temp = new ArrayList<>();
             temp.add(new TreeNode(0,null,null));
             return temp;
         }
        List<TreeNode> ans = new ArrayList<>();
        for(int i = 1 ; i <n-1 ; i++){
            List<TreeNode> left = allPossibleFBT(i);
            List<TreeNode> right = allPossibleFBT(n-i-1);
            if(left.size()==0||right.size()==0) continue;
            for(TreeNode l1 : left){
                for(TreeNode r1 : right){
                    TreeNode root = new TreeNode(0,l1,r1);
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}