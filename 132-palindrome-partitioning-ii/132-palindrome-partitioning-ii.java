class Solution {
    public int minCut(String s) {
        boolean[][] ispal = new  boolean[s.length()][s.length()];
        fillpalindrome(s,ispal);
        int[][] dp = new int[s.length()][s.length()];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
       return helper(0,s.length()-1,s,dp,ispal);
    }
    
    public int helper(int i , int j , String s,int[][] dp,boolean[][] ispal){
        if(i>j) return -1;
        if(i==j) return 0;
        int min  = (int)1e9;  
        if(dp[i][j]!=-1) return dp[i][j];
        for(int cuts = i ; cuts <= j ; cuts++){
             String cutted = s.substring(i,cuts+1);
            if(ispal[i][cuts]){
                //  System.out.println(cutted);
                min = Math.min(min,1+helper(cuts+1,j,s,dp,ispal));
            }   
        }
        return dp[i][j] = min;
    }
    
    
    public void fillpalindrome(String s, boolean[][] dp){
        for(int gap = 0 ; gap < dp.length ; gap++){
            for(int i=0,j = gap ; j < dp[0].length ;i++,j++){
                if(gap==0) dp[i][j] = true;
                else if(gap==1){
                    if(s.charAt(i)==s.charAt(j)) dp[i][j] = true;
                    else dp[i][j] = false;
                 }
                else{
                    if(s.charAt(i)!=s.charAt(j)) dp[i][j] = false;
                    else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
            }
        }
    }
}