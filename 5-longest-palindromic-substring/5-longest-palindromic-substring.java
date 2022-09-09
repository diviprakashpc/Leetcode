class Solution {
    public String longestPalindrome(String s) {
       return isPalindrome(s);
    }
    
    public String isPalindrome(String s){
        int[][] dp = new int[s.length()][s.length()];
        String lps = "";
        for(int gap = 0 ; gap < s.length() ; gap++){
            for(int i = 0,j=gap;j<dp[0].length&&i<dp.length ; i++,j++){
                if(gap==0){
                    dp[i][j] = 1;
                    if(dp[i][j]==1&&lps.length()<gap+1){
                        lps = s.substring(i,j+1);
                    }
                }else if(gap==1){
                    dp[i][j] = (s.charAt(i)==s.charAt(j)) ? 1 : 0;
                    if(dp[i][j]==1&&lps.length()<gap+1){
                        lps = s.substring(i,j+1);
                    }
                }else{
                    if(dp[i+1][j-1]==1&&s.charAt(i)==s.charAt(j)){
                        dp[i][j] = 1;
                    }
                    else dp[i][j] = 0;
                    if(dp[i][j]==1&&lps.length()<gap+1){
                        lps = s.substring(i,j+1);
                    }
                }
            }
        }
        return lps;
    }
}