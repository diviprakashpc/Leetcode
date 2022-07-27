class Solution {
    public List<Integer> findAnagrams(String txt, String pat) {
       List<Integer> ans = new ArrayList<>();
        int k = pat.length();
        int unique = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
         for(int itr = 0 ; itr < pat.length() ; itr++){
           map.put(pat.charAt(itr),map.getOrDefault(pat.charAt(itr),0)+1);
          
        }
        unique = map.size();
        while(j<txt.length()){
            if(map.containsKey(txt.charAt(j))){
                 map.put(txt.charAt(j),map.getOrDefault(txt.charAt(j),0)-1);
                 if(map.get(txt.charAt(j))==0) unique--;
            }
            if(j-i+1<k){
                j++;
            }
            else if(j-i+1==k){
                if(unique==0){
                    ans.add(i);
                }
                if(map.containsKey(txt.charAt(i))){
                 map.put(txt.charAt(i),map.getOrDefault(txt.charAt(i),0)+1);
                  if(map.get(txt.charAt(i))==1) unique++;
                 
            }
                i++;
                j++;
            }        
        }
        return ans;
    }
    
    boolean isAnagram(String s , int[] freq){
        
       int[] freq1 = new int[256];
        for(int i = 0 ; i < s.length() ; i++){
            freq1[s.charAt(i)]++;
        }
         
       for(int i = 0 ; i < s.length() ; i++){
           if(freq[s.charAt(i)]!=freq1[s.charAt(i)]) return false;
       }

        return true;
    }
}