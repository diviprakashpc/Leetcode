class Solution {
    public int numTrees(int n) {
       int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        
        for(int i = 2 ; i <=n ;i++){
            int count = 0;
            for(int j = 1 ; j <=i ; j++){
                int left = dp[j-1];
                int right = dp[i-j];
                count+=left*right;
            }
            dp[i] = count;
        }
        return dp[n];
    }
    
    public int helper(int n ){
        if(n<=0) return 1;
        if(n==1) return 1;
        int count = 0;
        for(int i = 1 ; i <=n ;i++){
            int left = numTrees(i-1);
            int right = numTrees(n - i);
            count+=(left*right);
        }
        return count;
    }
}