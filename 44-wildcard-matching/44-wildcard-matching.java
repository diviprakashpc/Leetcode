class Solution {
    public boolean isMatch(String s, String p) {
      
        boolean[][] dp = new boolean[s.length()+1][p.length()+1];
        dp[0][0] = true;
        for(int i = 1 ; i <= s.length() ; i++){
            dp[i][0] = false;
        }
        for(int j = 1 ; j <= p.length() ; j++){
            for(int ii = 1 ; ii<=j ; ii++){
                if(p.charAt(ii-1)!='*') {
                    dp[0][j] = false;
                    break;
                }
                dp[0][j] = true;
            }
        }
        
        for(int i = 1; i <=s.length() ; i++){
            for(int j = 1 ; j<=p.length();j++){
                char c1 = s.charAt(i-1);
                char c2 = p.charAt(j-1);
                    if(c1==c2||c2=='?'){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else if(c2=='*'){
                        dp[i][j] =  dp[i-1][j]||dp[i][j-1];
                    }
        
                   else  dp[i][j] = false;
            }
        }
        
        return dp[s.length()][p.length()];
        
    }
    
    public boolean helper(String s, String p ,int i , int j){
        if(i<0&&j<0) return true;
         if(j<0&&i>=0) return false;
        if(i<0&&j>=0){
            for(int ii = 0 ; ii<=j ; ii++){
                if(p.charAt(ii)!='*') return false;
            }
            return true;
        }
        char c1 = s.charAt(i);
        char c2 = p.charAt(j);
        if(c1==c2||c2=='?'){
            return helper(s,p,i-1,j-1);
        }
        else if(c2=='*'){
             return helper(s,p,i-1,j)||helper(s,p,i,j-1);
        }
        
       return false;
    }
}