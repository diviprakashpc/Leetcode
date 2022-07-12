class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] ans = new int[1];
        return helper(nums,nums.length-1,target,ans);
    }
    
    public int helper(int[] nums,int idx , int target,int[] ans){
         if(idx==-1){
             if(target==0){
                return 1;
             }
             return 0;
         }
        
        int add = helper(nums,idx-1,target-nums[idx],ans);
        int subtract =helper(nums,idx-1,target+nums[idx],ans);
        return add + subtract;
    }
}