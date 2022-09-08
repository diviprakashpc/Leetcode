class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        helper(candidates,target,0,ans,curr);
        return ans;
    }
    
    public void helper(int[] candidates, int target , int i , List<List<Integer>> ans, List<Integer> curr){
        if(target==0){
            List<Integer> temp = new ArrayList<>(curr);
            ans.add(temp);
            return;
        }
        if(i==candidates.length||target<0) return;
         
        curr.add(candidates[i]);
        helper(candidates,target-candidates[i],i,ans,curr);
        curr.remove(curr.size()-1);
        helper(candidates,target,i+1,ans,curr);
        
        }
    }
