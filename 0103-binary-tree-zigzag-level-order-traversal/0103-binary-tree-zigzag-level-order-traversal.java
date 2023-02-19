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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
       if(root==null) return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> ms = new Stack<>();
        Stack<TreeNode> cs = new Stack<>();
        ms.add(root);
       boolean lr = true;
        while(!ms.isEmpty()){
           int size  = ms.size();
          List<Integer> temp = new ArrayList<>();
          while(size-->0){
            TreeNode front = ms.pop();
            temp.add(front.val);
            if(!lr){
               if(front.right!=null) cs.push(front.right);
               if(front.left!=null) cs.push(front.left);
              
            }else{
               if(front.left!=null) cs.push(front.left);
               if(front.right!=null) cs.push(front.right);
         
            }
          }
          lr = !lr;
          ms = cs;
          cs = new Stack<>();
          ans.add(temp);
        }
      return ans;
    }
}