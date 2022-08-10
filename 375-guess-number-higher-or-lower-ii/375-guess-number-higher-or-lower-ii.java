class Solution {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row,-1);
        return helper(1,n,dp);
    }
    
    public int helper(int i , int j,int[][] dp ){
        if(i>j) return 0;
        if(i==j) {
            return 0;
        }
        if(dp[i][j]!=-1) return dp[i][j];
        int min = Integer.MAX_VALUE;
        for(int k = i ; k <=j ; k++){
            int lower = k + helper(i,k-1,dp);
            int higher = k + helper(k+1,j,dp);
            min = Math.min(min,Math.max(lower,higher));
        }
        return dp[i][j]=min;
    }
}