class Solution {
    public boolean stoneGame(int[] piles) {
        //Use Gap strategy b/c feel aaati hai
        boolean[][] dp = new boolean[piles.length][piles.length];
        
        for(int gap = 0 ; gap < dp.length ; gap++){
            for(int i = 0,j = gap ; j < dp.length ; i++,j++){
                if(gap==0){
                    dp[i][j] = true;
                }else if(gap==1){
                    dp[i][j] = true;
                }
                else{
                    boolean left = ((dp[i+2][j])&&(dp[i+1][j-1]));
                    boolean right = ((dp[i+1][j-1])&&(dp[i][j-2]));
                    dp[i][j] = left||right;
                }
            }
        }
        return dp[0][dp.length-1];
    }
}