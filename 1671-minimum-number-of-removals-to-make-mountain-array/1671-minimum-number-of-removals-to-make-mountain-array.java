class Solution {
    public int minimumMountainRemovals(int[] arr) {
         int[] dp = new int[arr.length];
        Arrays.fill(dp,1);
        for(int i = 0 ; i < arr.length ; i++){
            for(int prev = 0 ; prev < i ; prev++){
                if(arr[prev]<arr[i]&&dp[i]<1+dp[prev]){
                    dp[i] = 1 + dp[prev];
                }
            }
        }
        int max = 0;
        int[] dp2 = new int[arr.length];
        Arrays.fill(dp2,1);
        for(int i = arr.length-1 ; i >=0 ; i--){
            for(int prev = arr.length-1 ; prev > i ; prev--){
                if(arr[prev]<arr[i]&&dp2[i]<1+dp2[prev]){
                    dp2[i] = 1 + dp2[prev];
                }
            }
         if(dp[i] > 1 && dp2[i] > 1) 
                max = Math.max(dp[i]+dp2[i]-1, max);
        }
        
        
        return arr.length-max;
        
    }
}