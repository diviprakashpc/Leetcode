class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum= Arrays.stream(nums).sum();
        int[][] dp = new int[nums.length][2*sum+1];
       
        for(int i = 0 ;  i < dp.length ; i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(nums,nums.length-1,0,target,sum,dp);
    }
    
    public int helper(int[] nums,int idx ,int curr, int target,int sum,int[][] dp){
         if(idx==-1){
             int count = 0;
             if(target==curr){
               count++;
             }
             return count;
         }
        if(dp[idx][sum+curr]!=-1) return dp[idx][sum+curr];
        int add = helper(nums,idx-1,curr+nums[idx],target,sum,dp);
        int subtract =helper(nums,idx-1,curr-nums[idx],target,sum,dp);
      dp[idx][sum+curr] = add + subtract;
        return dp[idx][sum+curr];
    }
}