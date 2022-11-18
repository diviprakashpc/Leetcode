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
    public TreeNode createBinaryTree(int[][] descriptions) {
        HashMap<Integer,int[]> ptc = new HashMap<>();
        HashMap<Integer,Integer> ctp = new HashMap<>();
        for(int[] row : descriptions){
            int p = row[0];
            int c = row[1];
            int isLeft = row[2];
            ptc.putIfAbsent(p,new int[2]);
            if(isLeft==1){
                ptc.get(p)[0] = c;
            }else{
              ptc.get(p)[1] = c;
            }
          ctp.put(c,p);
        
        }
      
//       for(int i : ptc.keySet()){
//         System.out.print(i+" -> " + ptc.get(i)[0] + " "+ ptc.get(i)[1]+" ");
//       }
      
      TreeNode root= null;
      for(Integer par : ptc.keySet()){
        if(!ctp.containsKey(par)){
          root=  new TreeNode(par);
        }
      }
        // System.out.println(root.val);
       TreeNode res = constructTree(root,ptc,ctp);
      return res;
    }
  
    public TreeNode constructTree(TreeNode root,  HashMap<Integer,int[]> ptc , HashMap<Integer,Integer> ctp){
      
      if(root==null) return root;
      if(root.val==0) return null;
      if(!ptc.containsKey(root.val)) return root;
     
      TreeNode left = constructTree(new TreeNode(ptc.get(root.val)[0]),ptc,ctp);
      TreeNode right = constructTree(new TreeNode(ptc.get(root.val)[1]),ptc,ctp);
      root.left = left;
      root.right = right;
      return root;
      
      
    }
}