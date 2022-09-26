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
    public TreeNode recoverFromPreorder(String s) {
        HashMap<TreeNode,Integer> map = new HashMap<>();
        TreeNode root;
        Stack<TreeNode> stack = new Stack<>();
        for(int i = 0 ; i<s.length();){
            int level = 0;
            while(s.charAt(i)=='-') {
                level++;
                i++;
            } 
            int start = i;
            while(i<s.length()&&Character.isDigit(s.charAt(i))){
              i++;
            } 
            int val = Integer.parseInt(s.substring(start,i));
            TreeNode n = new TreeNode(val);
            map.put(n,level);
            
            if(stack.size()==0){
              stack.push(n);
            }else{
                while(level-1!=map.get(stack.peek())){
                  stack.pop();
                }
               TreeNode parent = stack.peek();
               if(parent.left==null) parent.left = n;
               else parent.right=n;
              
               stack.push(n);
            }
          
        }
        
        while(stack.size()!=1) stack.pop();
        
        return stack.pop();
         
    }
  
}