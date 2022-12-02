class Solution {
    public boolean closeStrings(String word1, String word2) {
         if(word1.length()!=word2.length()) return false;
        int[] a1 = new int[26];
        int[] a2= new int[26];
        for(int i = 0 ; i < word1.length() ; i++){
            a1[word1.charAt(i)-'a']++;
            a2[word2.charAt(i)-'a']++;
        }
      
       for(int i = 0 ;  i < 26 ; i++){
         if(a1[i]==0&&a2[i]==0) continue;
         if(a1[i]!=0 && a2[i]!=0) continue;
         return false;
       }
       
       Arrays.sort(a1);
       Arrays.sort(a2);
       for(int i = 0 ; i < 26 ; i++){
         if(a1[i]!=a2[i]) return false;
       }
      return true;
    }
}