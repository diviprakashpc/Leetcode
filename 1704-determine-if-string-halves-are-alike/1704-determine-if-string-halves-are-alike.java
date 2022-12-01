class Solution {
    public boolean halvesAreAlike(String s) {
        
      int len_part = s.length()/2;
      int v1=0,v2=0;
      for(int i = 0 ; i < len_part ; i++){
        char ch = s.charAt(i);
        if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U') v1++;
      }
      
      for(int i = len_part ; i<s.length() ; i++){
         char ch = s.charAt(i);
         if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'||ch=='A'||ch=='E'||ch=='I'||ch=='O'||ch=='U') v2++;
      }
      
      return v1==v2;
    }
}