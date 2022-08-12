class Solution {
    public int divisorSubstrings(int num, int k) {
       String s = Integer.toString(num);
        int i = 0;
        int j =0 ;
        int ans = 0;
        String curr = "";
        while(j<s.length()){
           curr+=s.charAt(j);
            if(j-i+1<k) j++;
            else if(j-i+1==k){
                int x = Integer.parseInt(curr);
                
                if(x!=0&&num%x==0){
                    ans++;
                    
                }
                  curr = curr.substring(1);  
                    i++;
                    j++;
            }
        }
        return ans;
    }
}