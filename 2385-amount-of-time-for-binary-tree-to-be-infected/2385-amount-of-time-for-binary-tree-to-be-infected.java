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
    public int amountOfTime(TreeNode root, int start) {
        HashMap<Integer,List<Integer>> map = new HashMap<>();
        createGraph(root,map);
        Queue<Integer> q = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        q.add(start);
        visited.add(start);
        //System.out.println(map);
        int time = 0;
        while(!q.isEmpty()){
            int size = q.size();
            time++;
            while(size-->0){
                  Integer front = q.remove();
                for(Integer n : map.get(front)){
                    if(!visited.contains(n)){
                        visited.add(n);
                        q.add(n);
                    }
                }
            }
        }
        return time-1;
    }
    
    
    public void createGraph(TreeNode root, HashMap<Integer,List<Integer>> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        map.put(root.val,new ArrayList<>());
        while(!q.isEmpty()){
           TreeNode front =  q.remove();
            if(!map.containsKey(front.val)) map.put(front.val,new ArrayList<>());
            if(front.left!=null){
                 if(!map.containsKey(front.left.val)) map.put(front.left.val,new ArrayList<>());
               map.get(front.val).add(front.left.val);
               map.get(front.left.val).add(front.val);
               q.add(front.left);
            }
            if(front.right!=null){
                 if(!map.containsKey(front.right.val)) map.put(front.right.val,new ArrayList<>());
                  map.get(front.val).add(front.right.val);
                  map.get(front.right.val).add(front.val);
                  q.add(front.right);
            }
        }
    }
}