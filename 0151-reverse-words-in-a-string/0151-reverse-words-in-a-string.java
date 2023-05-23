class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder("");
        int i = s.length()-1;
        int j = s.length()-1;
        while(j>=0){
            while(j>=0&&s.charAt(j)==' '){
                j--;
            }
            if(j<0) break;
            i=j;
            while(j>=0&&s.charAt(j)!=' '){
                j--;
            }
            if(sb.length()>0) sb.append(" ");
            sb.append(s.substring(j+1,i+1));
            if(j<0) break;
            i = j;
        }
        return sb.toString();
    }
}