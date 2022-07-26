class Solution {
    public String minWindow(String s, String p) {
       int len = 0;
        int minlen = Integer.MIN_VALUE;
        String ans = "";
        int[] str = new int[256];
        int[] pat = new int[256];
        for(int i = 0 ; i < p.length() ; i++){
            pat[p.charAt(i)]++;
        }
        int i = 0;
        int j = 0;
        int cnt = 0;
        int dcnt = p.length(); //desired count
        
        while(true){
            boolean f1 = false;
            boolean f2 = false;
            while(j<s.length()&&cnt<dcnt){
                char ch = s.charAt(j);
                str[ch]++;
                if(str[ch]<=pat[ch]){
                    j++;
                    cnt++;
                }else{
                    j++;
                }
                f1 = true;
            }
           
            while(i<j&&cnt==dcnt){
             String path = s.substring(i,j);
              if(ans.length()==0||ans.length()>path.length()){
                  ans = path;
              }
                char ch = s.charAt(i);
                if(str[ch]>pat[ch]){
                    i++;
                    str[ch]--;
                }
                else{
                     str[ch]--;
                    cnt--;
                    i++;
                }
                f2= true;
            }
            
            if(!f1&&!f2) break;
        }
        
        return ans;
    }
}