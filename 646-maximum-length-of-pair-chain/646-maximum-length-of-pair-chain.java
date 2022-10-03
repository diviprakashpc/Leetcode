class Solution {
    public int findLongestChain(int[][] nums) {
        Arrays.sort(nums,(a,b)->a[0]-b[0]);
        int[] dp = new int[nums.length];
        int maxlen = 1;
        dp[0] = 1;
        for(int i = 1 ; i < dp.length ; i++){
           int max = 0;
          for(int j = i-1 ; j>=0 ; j--){
            if(nums[j][1]<nums[i][0])
            max = Math.max(max,dp[j]);
          }
          dp[i] = 1+max;
          maxlen = Math.max(maxlen,dp[i]);
        }
      return maxlen;
    }
}