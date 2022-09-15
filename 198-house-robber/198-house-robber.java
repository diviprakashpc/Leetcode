class Solution {
    public int rob(int[] nums) {
        if(nums.length==0) return 0;
        if(nums.length==1) return nums[0];
       int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2 ; i < dp.length ; i++){
            int not_take = dp[i-1];
            int take = nums[i] + dp[i-2];
            dp[i] = Math.max(not_take,take);
        }
        return dp[nums.length-1];
    }
    
    public int helper(int[] nums , int i){
        if(i<0) return 0;
        if(i==0) return nums[i];
        int not_take = helper(nums,i-1);
        int take = (i>=1)?nums[i] + helper(nums,i-2):Integer.MIN_VALUE;
        return Math.max(not_take,take);
    }
}