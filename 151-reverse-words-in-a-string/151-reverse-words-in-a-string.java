class Solution {
    public String reverseWords(String s) {
        String res = "";
        String curr = "";
        int i = 0;
        
        while(i<s.length()){
            while(i<s.length()&&s.charAt(i)==' '){
                i++;
            }
            if(i>=s.length()) break;
            int j = i+1;
            while(j<s.length()&&s.charAt(j)!=' '){
                j++;    
            }
            res = s.substring(i,j) + " "+ res;
            i = j+1;
        }
        res = res.substring(0,res.length()-1);
        return res;
    }
}