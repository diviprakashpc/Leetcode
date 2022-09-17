class Solution {
    public int minFallingPathSum(int[][] matrix) {
       int n = matrix.length;
        int[][] dp = new int[n][n];
      for(int i = n-1 ; i>=0 ; i--){
          for(int j = n-1 ; j>=0 ; j--){
            //  if(j>i) continue;
              if(i==n-1){
                  dp[i][j] = matrix[i][j];
              }else{
                  int call1 =  (i<n-1)?dp[i+1][j]:Integer.MAX_VALUE;
                  int call2 = (i<n-1&&j<n-1)?dp[i+1][j+1]:Integer.MAX_VALUE;
                  int call3 = (i<n-1&&j>=1)?dp[i+1][j-1]:Integer.MAX_VALUE;
                  dp[i][j] = matrix[i][j] + Math.min(call1,Math.min(call2,call3));
              }
          }
      
      }
        
        int ans = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++){
            ans = Math.min(ans,dp[0][i]);
        }
        return ans;
    
    }
    
    public int sum(int[][] arr , int i , int j ){
        if(i<0||i>=arr.length||j<0||j>=arr.length){
            return Integer.MAX_VALUE;
        }
        if(i==arr.length-1) return arr[i][j];
        
        return arr[i][j] + Math.min(sum(arr,i+1,j),Math.min(sum(arr,i+1,j+1),sum(arr,i+1,j-1)));
    }
}