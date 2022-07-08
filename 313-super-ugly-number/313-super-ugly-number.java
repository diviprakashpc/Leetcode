class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
       int[] ptrs = new  int[primes.length];
        Arrays.fill(ptrs,1);
        long[] dp = new long[n+1];
        dp[1] = 1;
        
        for(int i = 2 ; i <dp.length ; i++){
            long min = Long.MAX_VALUE;
            for(int j = 0 ; j < primes.length ; j++){
                min = Math.min(min,primes[j]*dp[ptrs[j]]);
            }
              dp[i] = min;
            for(int j = 0 ; j < primes.length ; j++){
                if(primes[j]*dp[ptrs[j]]==min){
                    ptrs[j]++;
                }
            }
          
        }
        
        return (int)dp[n];
    }
}