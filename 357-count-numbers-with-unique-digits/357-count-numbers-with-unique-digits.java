class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        if(n==0) return 1;
        int[] dp = new int[n];
        dp[0] = 9;
        int cnt = 9;
        int ans = 10;
        for(int i = 1 ; i < n ; i++){
           dp[i] = cnt*dp[i-1];
            ans+=dp[i];
            cnt--;
        }
        return ans;
    }
}