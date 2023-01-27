class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Set<String> set = new HashSet<>();
        for(String s : words){
            set.add(s);
        }
        List<String> ans = new ArrayList<>();
        for(String s : words){
            set.remove(s);
            if(wordBreak(s,set)) ans.add(s);
            set.add(s);
        }
        return ans;
    }
    
    
     public boolean wordBreak(String s, Set<String> wordDict) {
        int n = s.length();
        int[] dp = new int[n];
        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j<=i ; j++){
                if(wordDict.contains(s.substring(j,i+1))){
                    if(j>0){
                        dp[i] +=dp[j-1];
                    }
                    else{
                        dp[i]+=1;
                    }
                }
            }
        }
        
        return dp[n-1]>0;
    }
}