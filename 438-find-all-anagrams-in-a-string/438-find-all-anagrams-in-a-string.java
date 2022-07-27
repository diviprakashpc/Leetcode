class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
        int count = 0;
        int k = pat.length();
        int[] freq = new int[256];
        int i = 0;
        int j = 0;
        List<Integer> ans = new ArrayList<>();
        while(j<txt.length()){
           freq[txt.charAt(j)]++;
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(isAnagram(pat,freq)){
                    ans.add(i);
                }
                freq[txt.charAt(i)]--;
                i++;
                j++;
            }        
        }
        return ans;
    }
    
    boolean isAnagram(String s , int[] freq){
        
       int[] freq1 = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            freq1[s.charAt(i)]++;
        }
         
       for(int i = 0 ; i < s.length() ; i++){
           if(freq[s.charAt(i)]!=freq1[s.charAt(i)]) return false;
       }

        return true;
    }
}