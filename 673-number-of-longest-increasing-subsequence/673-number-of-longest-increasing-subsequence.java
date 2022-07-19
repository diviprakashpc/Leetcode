class Solution {
    public int findNumberOfLIS(int[] arr) {
         int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        int ans = 1;
       int[] count = new int[arr.length];
        Arrays.fill(count,1);
        for (int i = 1; i < arr.length; i++) {
            for (int prev = 0; prev < i; prev++) {
                if (arr[prev] < arr[i]&&dp[i]<1+dp[prev]) {
                    dp[i] = 1+dp[prev];
                    count[i] = count[prev];
                }
                else if(arr[prev] < arr[i]&&dp[i]==1+dp[prev]){
                    count[i] += count[prev];
                }
            }           
            ans = Math.max(ans,dp[i]);
        }
       int nos = 0;
        for(int i = 0 ; i < count.length ; i++){
            if(dp[i]==ans){
                nos+=count[i];
            }
        }
        return nos;
	}
    
}