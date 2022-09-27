class Solution {
    public boolean canTransform(String start, String target) {
      if(start.length()!=target.length()) return false;
      int ls = 0;
      int rs = 0;
      int lt = 0;
      int rt = 0;
      for(int i = 0  ; i < start.length() ;i++){
        if(start.charAt(i)=='L') ls++;
        else if(start.charAt(i)=='R') rs++;
      }
      
      for(int i = 0  ; i < target.length() ;i++){
        if(target.charAt(i)=='L') lt++;
        else if(target.charAt(i)=='R') rt++;
      }
      
      if(ls!=lt||rs!=rt) return false;
      
      int n = start.length();
      int i = 0;
      int j = 0;
      while(i<n&&j<n){
        while(i<n&&start.charAt(i)=='X') i++;
        while(j<n&&target.charAt(j)=='X') j++;
        if(i<n&&j<n&&start.charAt(i)!=target.charAt(j)) return false;
        if(i<n&&j<n&&(start.charAt(i)=='L'&&i<j||start.charAt(i)=='R'&&i>j)) return false;
        i++;
        j++;
      }
      return true;  
    }
}