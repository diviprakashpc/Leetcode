class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        
        for(int i =0 ; i < dp.length ; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[dp.length-1] = 0;
        for(int i = dp.length-2 ; i>=0; i--){
            int min = Integer.MAX_VALUE;
            for(int j = 1 ; j <=nums[i] ; j++){
             min = (i+j<dp.length) ? Math.min(min,dp[i+j]) : min;
            }
            dp[i] = (min!=Integer.MAX_VALUE)? 1 + min : min;
        }
        
        return dp[0];
    }}