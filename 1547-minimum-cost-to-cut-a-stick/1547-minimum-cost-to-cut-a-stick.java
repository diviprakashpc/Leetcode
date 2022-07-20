class Solution {
    public int minCost(int n, int[] cuts) {
      List<Integer> al = new ArrayList<>();
      for(int i : cuts) al.add(i);
      al.add(n);
      al.add(0,0);
      Collections.sort(al);
      int[][] dp = new int[cuts.length+2][cuts.length+2];
      for(int i = cuts.length ; i >=1 ; i--){
          for(int j = 1 ; j<=cuts.length ; j++){
              if(j<i) continue;
        int min = Integer.MAX_VALUE;
        for(int k = i ; k<=j ; k++){
            int cost = al.get(j+1) - al.get(i-1) + dp[i][k-1] + dp[k+1][j];
            min = Math.min(min,cost);
        } 
        dp[i][j]=min;
    }
      }
                                                      
        return dp[1][cuts.length];
    }
    
    public int helper(int i , int j , List<Integer> al,int[][] dp ){
        if(i>j) return 0;
        int min = Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        for(int k = i ; k<=j ; k++){
            int cost = al.get(j+1) - al.get(i-1) + helper(i,k-1,al,dp) + helper(k+1,j,al,dp);
            min = Math.min(min,cost);
        }
        return dp[i][j]=min;
    }
}