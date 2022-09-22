class Solution {
    public String reverseStr(String s, int k) {
        if(s.length()<k) return reverse(s);
        int i = 0;
        String ans = "";
        while(i<s.length()){
            int j = i;
            while(j<s.length()&&j-i!=2*k){
                j++;
            }
            int cnt = j-i+1;
            if(cnt>=k){
              ans+=reverse(s.substring(i,i+k));
                ans+=s.substring(i+k,j);
            }
            else{
                ans+=reverse(s.substring(i));
            }
            i= j;
        }
        return ans;
    }
    
    public String reverse(String s){
        return new StringBuilder(s).reverse().toString();
    }
}