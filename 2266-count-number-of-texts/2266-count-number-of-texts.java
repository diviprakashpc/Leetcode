class Solution {
  static int mod = (int)1e9 + 7;
  static int[] letters = {0,0,3,3,3,3,3,4,3,4};
    
  public int countTexts(String pressedKeys) {
      int[] dp = new int[pressedKeys.length()+1];
      dp[pressedKeys.length()] = 1;
      for(int i = pressedKeys.length()-1 ; i>=0 ; i--){
         int itr = i;
         int ans = 0;
         int cnt = 0;
     //   System.out.println("i here is "+ i);
         for(;itr<pressedKeys.length()&&pressedKeys.charAt(itr)==pressedKeys.charAt(i)&&cnt<letters[pressedKeys.charAt(i)-'0'];itr++,cnt++ ){
            ans = (ans%mod + dp[itr+1]%mod)%mod;
         }
       
        dp[i] = ans;
      }
      return dp[0];
    }
  
  public int helper(String s,int[] dp){
    if(s.length()==0) return 1;
    if(dp[s.length()]!=-1) return dp[s.length()];
    int itr = 0;
    long ans = 0;
    for(;itr<s.length()&&s.charAt(itr)==s.charAt(0)&&itr<letters[s.charAt(0)-'0'];itr++){
        ans = (ans%mod + helper(s.substring(itr+1),dp)%mod)%mod;
    }
    return dp[s.length()] = (int)ans;
  }
   
}