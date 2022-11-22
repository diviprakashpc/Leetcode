class Solution {
    public int numSquares(int n) {
        if(n==0||n==1||n==2||n==3) return n;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for(int i = 4 ; i<=n ; i++){
           int min = i;
          for(int j = 1 ; j <= Math.pow(i,0.5); j++){
               min = Math.min(min,1+dp[i-(int)Math.pow(j,2)]);
          }
          dp[i] = min;
        }
      return dp[n];
    }
}