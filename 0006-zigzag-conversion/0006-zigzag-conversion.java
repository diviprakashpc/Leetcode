class Solution {
    public String convert(String s, int n) {
     List<Character>[] ans = new List[n];
        for(int i = 0 ; i < n ; i++) ans[i] = new ArrayList<>();

     if(n==1) {
        return s;
        }
 

      boolean flag = false;
    	int idx = 0;
    	for(int i = 0 ; i < s.length() ; i++) {
    		char ch = s.charAt(i);
    		
    		ans[idx].add(ch);
    		if(flag) idx--;
    		else idx++;
    		
    	   if(idx==n) {
    		   idx = n-2;
    		   flag = true;
    	   }
    	   else if(idx==-1) {
    		   idx = 1;
    		   flag = false;
    	   }
    	}
      
    StringBuilder res = new StringBuilder("");
      for(List<Character> l : ans){
        for(Character c : l){
          res.append(c);
        }
      }
      return res.toString();

    }
}