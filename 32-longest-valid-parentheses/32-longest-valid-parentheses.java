class Solution {
    public int longestValidParentheses(String s) {
        if(s.length()==0||s.length()==1) return 0;
        int[] dp = new int[s.length()+1];
        dp[0] = 0;
        
        int ans = 0;
        for(int i = 1 ; i < dp.length ; i++){
            char ch = s.charAt(i-1);
            int j = i-1 - dp[i-1] -1;
            if(j>=0&&s.charAt(j)=='('&&ch==')'){
                dp[i]  = dp[i-1] + dp[j] + 2; 
                ans = Math.max(ans,dp[i]);
            }
        }
        return ans;
    }
}