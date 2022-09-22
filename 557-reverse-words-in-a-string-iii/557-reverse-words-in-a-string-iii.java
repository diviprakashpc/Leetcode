class Solution {
    public String reverseWords(String s) {
        
        String ans = "";
        for(int i = 0 ; i < s.length() ;){
            int j = i ;
            String temp = "";
            while(j<s.length()&&s.charAt(j)!=' ') {
               
                j++;
            }
            String rev = reverse(s.substring(i,j));
            ans+=rev;
            if(j!=s.length()) ans+=" ";
            i = j+1;
        }
        return ans;
    }
    
    public String reverse(String s){
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();
        return sb.toString();
    }
}