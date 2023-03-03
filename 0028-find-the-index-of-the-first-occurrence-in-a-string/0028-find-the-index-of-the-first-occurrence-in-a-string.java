class Solution {
    public int strStr(String haystack, String needle) {
        int m = needle.length();
        int n = haystack.length();
        int[] lps = new int[m+n+1];
        createLPS(lps,needle,haystack);
        for(int i = 0 ; i < lps.length ; i++){
            if(lps[i]==m){
                return i-2*m;
            }
        }
        return -1;
        
    }
    
    public void createLPS(int[] lps, String pattern, String text){
        int i = 1;
        int len = 0;
        String s = pattern + "$" + text;
        while(i<s.length()){
            if(s.charAt(i)==s.charAt(len)){
                len++;
                lps[i] = len;
                i++;
            }
            else{
                if(len>0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
    }
      
}