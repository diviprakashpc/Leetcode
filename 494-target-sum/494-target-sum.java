class Solution {
    public int findTargetSumWays(int[] nums, int target) {
     
        return countPartitions(nums.length,target,nums);
    }
   public int countPartitions(int n, int d, int[] arr) {
        // Write your code here.
        int sum = Arrays.stream(arr).sum();
        if(sum-d<0||(sum-d)%2!=0) return 0;
        return helper(arr,(sum-d)/2);
    }
    
    public int helper(int[] arr , int tar){
         int[][] dp = new int[arr.length][tar+1];
            if(arr[0]==0) dp[0][0] = 2;   
            else dp[0][0] = 1;    
            if(arr[0]!=0&&arr[0]<=tar) dp[0][arr[0]] = 1;  
            for(int i = 1 ;  i < arr.length ; i++){
                for(int j = 0 ; j <= tar ; j++){
                        int take = (j>=arr[i]) ? dp[i-1][j-arr[i]] : 0;
                        int nottake = dp[i-1][j];
                        dp[i][j] = (take + nottake);
                }
            }
            return dp[arr.length-1][tar];
    }
   
}