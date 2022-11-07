class Solution {
    public long makeIntegerBeautiful(long n, int target) {
      
      String num = Long.toString(n);
      String ans = "";
      int currsum = 0;
      for(int i = 0 ; i < num.length() ; i++){
          currsum+=(num.charAt(i)-'0');
        }
      if(currsum<=target) return 0;
      int j = num.length()-1;
      while(j>=0&&num.charAt(j)=='0') {
        ans = ans + '0';
        j--;
      }
      int val = num.charAt(j) -'0';
      int toadd = 10 - val;
      ans = Integer.toString(toadd)+ans;
      currsum-=val;
      currsum+=1;
      int pc = 1;
      if(currsum<=target) return Long.parseLong(ans);
      for(int i = j-1 ; i>=0 ; i--){
           if(currsum<=target){
             return Long.parseLong(ans);
          }
           val = num.charAt(i) - '0' + pc;
           toadd = 10 - val;
          ans = Integer.toString(toadd) + ans;
          currsum-=val;
          currsum+=1;
         
      }
       if(currsum<=target)  return Long.parseLong(ans);
       return 1L;
    }
}