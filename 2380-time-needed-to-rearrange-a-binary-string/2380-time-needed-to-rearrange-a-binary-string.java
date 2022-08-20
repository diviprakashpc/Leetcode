class Solution {
    public int secondsToRemoveOccurrences(String s) {
       int ans = 0;
        StringBuilder sb = new StringBuilder(s);
        while(true){
            int i = 0;
            int j = 1;
            int cnt = 0;
            while(j<sb.length()){
                if(sb.substring(i,j+1).equals("01")){
                    char temp = sb.charAt(i);
                    sb.setCharAt(i,sb.charAt(j));
                     sb.setCharAt(j,temp);
                    i+=2;
                    j+=2;
                    cnt++;
                }
                else {
                    i++;
                    j++;
                }
            }
            ans++;
            if(cnt==0) break;
        }
        return ans-1;
    }
}