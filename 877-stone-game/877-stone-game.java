class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        boolean[][] dp = new boolean[n][n];
        for(int i = n-1 ; i>=0 ; i--){
            for(int j =  0 ; j <= i ; j++){
                if(i>j) dp[i][j] = false;
                else if(i==j) dp[i][j] = true;
                else if(j==i+1) dp[i][j] = true;
                else{
                boolean left = (dp[i+2][j])&(dp[i+1][j-1]);
                boolean right = (dp[i+1][j-1])&(dp[i+2][j-1]);
                dp[i][j]= left|right;  
                }
            }
        }
        return dp[n-1][n-1];
        
        // return  helper(piles,0,piles.length-1); 
    }
    
    public boolean helper(int[] arr , int i , int j){
        if(i>j) return true;
        //base case
        if(i==j){
           return true; 
        }
          if(j-i==1){
              return true;
          }
        boolean left = (helper(arr,i+2,j)&helper(arr,i+1,j-1));
        boolean right = (helper(arr,i+1,j-1)&helper(arr,i+2,j-1));
        return left|right;
    }
}