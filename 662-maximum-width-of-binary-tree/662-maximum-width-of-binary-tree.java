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
    static class Pair{
      TreeNode node;
      int idx;
      Pair(TreeNode node , int idx){
        this.node = node;
        this.idx = idx;
      }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,0));
        int maxwidth = 0;
        while(!q.isEmpty()){
          int size = q.size();
          int lm = q.peek().idx;
          int rm = lm;
          while(size>0){
             Pair front = q.remove();
           // System.out.println(front.node.val+" and its index"+front.idx);
             rm = Math.max(front.idx,rm);
             if(front.node.left!=null){
                q.add(new Pair(front.node.left,2*front.idx+1));
             }
             if(front.node.right!=null){
               q.add(new Pair(front.node.right,2*front.idx+2));
             }
            size--;
          }
          // System.out.println("rm is "+rm+" lm is "+ lm+" and "+(rm-lm+1));
          maxwidth = Math.max(maxwidth,rm-lm+1);
        }
      return maxwidth;
    }
}