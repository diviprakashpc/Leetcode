class Solution {
    long m = (long)1e9+7;
    public int numRollsToTarget(int n, int k, int target) {
        long[][] dp = new long[n+1][target+1];
        for(int i = 0 ; i<=n ; i++){
            for(int j = 0; j<=target ; j++){
                if(i==0&&j==0) dp[i][j] = 1;
                else if(i==0||j==0) dp[i][j] = 0;
                else{
                    long totalways = 0;
                    for(int itr = 1 ; itr<=k ; itr++){
                        if(j-itr>=0)
                        totalways = (totalways%m + dp[i-1][j-itr]%m)%m;
                    }
                    dp[i][j] = totalways;
                }
            }
        }
       
        return (int)dp[n][target];
    }
    public long helper(int n, int die , int k ,int target){
        if(die==0&&target==0) return 1;
        if(die==0) return 0;
        if(target<=0) return 0;
        long ways = 0;
        for(int i = 1 ; i<=k ;i++){
            ways = ways + helper(n,die-1,k,target-i);
        }
        return ways;
    }
}