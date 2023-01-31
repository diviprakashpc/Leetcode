class Solution {
    public int bestTeamScore(int[] scores, int[] ages) {
        Pair[] pairs = new Pair[scores.length];
        for(int i = 0 ; i < scores.length ; i++){
            pairs[i] = new Pair(scores[i],ages[i]);
        }
         int[] dp = new int[pairs.length];
         Arrays.sort(pairs);
         int ans = 0;
         for(int i = pairs.length-1 ; i>=0 ; i--){
             int maxi = 0;
             for(int j = i+1 ; j < pairs.length ; j++){
                 if(pairs[i].score<=pairs[j].score){
                     maxi = Math.max(maxi,dp[j]);
                 }
             }
             dp[i] = pairs[i].score + maxi;
             ans = Math.max(ans,dp[i]);
         }
        
        return ans;
    }
    
    public int helper(Pair[] pairs , int idx ,int last,int[][] dp){
        if(idx==pairs.length){
            return 0;
        }
        if(dp[idx][last]!=-1) return dp[idx][last];
        boolean conflict = false;
        if(pairs[idx].score<last) conflict = true;
        int take = Integer.MIN_VALUE;
        int not_take = Integer.MIN_VALUE;
        if(!conflict){
            take = pairs[idx].score + helper(pairs,idx+1,pairs[idx].score,dp);
        }
        not_take = helper(pairs,idx+1,last,dp);
        return dp[idx][last] = Math.max(take,not_take);
    }

   static class Pair implements Comparable<Pair>{
       int score;
       int age;
       Pair(int s,int a){
           score = s;
           age = a;
       }
       
       public int compareTo(Pair p){
           return (this.age==p.age)?this.score - p.score : this.age - p.age;
       }
   }
}