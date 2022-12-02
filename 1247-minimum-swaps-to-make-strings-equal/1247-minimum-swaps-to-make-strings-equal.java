class Solution {
 
    public int minimumSwap(String s1, String s2) {
        int xmis = 0; // mismatch with s1(X) and s2(Y)
        int ymis = 0;  // mismatch with s1(Y) and s2(X)
        for(int i = 0 ; i < s1.length() ; i++){
          if(s1.charAt(i)=='x'&&s2.charAt(i)=='y') xmis++;
          if(s1.charAt(i)=='y'&&s2.charAt(i)=='x') ymis++;
        }
      
        if((xmis+ymis)%2!=0) return -1;
        
        int swaps = xmis/2 + ymis/2;
        if(xmis%2!=0) swaps+=2;
        return swaps;
    }
}