class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
            int max = maxfreq(map);
            int rem = j-i+1 - max;
            if(rem<=k){
                ans = Math.max(ans,j-i+1);
            }
            else{
                while(i<=j&&rem>k){
                    map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)-1);
                   i++;
                    rem = j-i+1 - maxfreq(map);
                   
                    ans = Math.max(ans,j-i+1);
                }
            }
            j++;
        }
        return ans;
    }
    
    public int maxfreq(HashMap<Character,Integer> map){
         int max = 0;
            for(Character c : map.keySet()){
                if(map.get(c)>max) max = map.get(c);
            }
        return max;
    }
}