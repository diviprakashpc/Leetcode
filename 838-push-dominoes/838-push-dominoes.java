class Solution {
    public String pushDominoes(String dominoes) {
        
      char[] ch = new char[dominoes.length()+2];
      ch[0] = 'L';
      ch[ch.length-1] = 'R';
      for(int i = 1 ; i < ch.length-1 ; i++) ch[i] = dominoes.charAt(i-1);
      int k = 1;
      int j = 0;
      while(k<ch.length){
        while(ch[k]=='.'){
            k++;
        }
        if(k-j>1) evaluateEffects(ch,j,k);
        j = k;
        k++;
    } 
      StringBuilder sb = new StringBuilder();
      for(int i = 1 ; i < ch.length-1 ; i++){
        sb.append(ch[i]);
      }
                    
      return sb.toString();
    }
  
  public void evaluateEffects(char[] ch, int i , int j){
    
      if(ch[i]=='L'&&ch[j]=='L'){
             while(i<j){
            ch[i++] = 'L';
          }
      }
      else if(ch[i]=='R'&&ch[j]=='R'){
          while(i<j){
            ch[i++] = 'R';
          }
      }
      else if(ch[i]=='L'&&ch[j]=='R'){
        //do nothing
      }
      else{
        int diff = j - i + 1;
         int mid = (i+j)/2;
        if(diff%2==0){
         
          while(i<=mid){
            ch[i++] = 'R';
          }
          while(i<j) ch[i++] = 'L';
        }
        else{
          while(i<=mid-1) ch[i++] = 'R';
          i++;
          while(i<j) ch[i++] = 'L';
        }
      }
  }
}