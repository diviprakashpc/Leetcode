class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int[] ans = new int[1];
        return helper(nums,0,target,ans);
    }
    
    public int helper(int[] nums,int idx , int target,int[] ans){
         if(idx==nums.length){
             if(target==0){
                return 1;
             }
             return 0;
         }
        
        int add = helper(nums,idx+1,target-nums[idx],ans);
        int subtract =helper(nums,idx+1,target+nums[idx],ans);
        return add + subtract;
    }
}