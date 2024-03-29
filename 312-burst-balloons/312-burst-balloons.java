class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[nums.length][nums.length];
        for(int i = n-1 ; i>=0 ;i--){
            for(int j = 0 ; j < n ; j++){
                if(i>j) continue;
             int max = Integer.MIN_VALUE;
             for(int idx = i ; idx<=j ; idx++){
                int l1 = (i-1>=0) ? nums[i-1] : 1;
                int l2  = (j+1<nums.length) ? nums[j+1] : 1;
                int cost = l1*l2*nums[idx];
                int left = (idx-1>=i)?dp[i][idx-1]:0;
                int right = (idx+1<=j)?dp[idx+1][j]:0;
                max = Math.max(max,cost+left+right);    
            }
                    dp[i][j] = max;
        }
      
    }
     return dp[0][n-1];
    }
    public int helper(int i, int j , int[] nums,int[][] dp){
        if(i>j) return 0;
        int max = Integer.MIN_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int idx = i ; idx<=j ; idx++){
            int l1 = (i-1>=0) ? nums[i-1] : 1;
            int l2  = (j+1<nums.length) ? nums[j+1] : 1;
            int cost = l1*l2*nums[idx];
            int left = helper(i,idx-1,nums,dp);
            int right = helper(idx+1,j,nums,dp);
            max = Math.max(max,cost+left+right);
        }
        return dp[i][j]=max;
    }
}