class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        int totalwords = words.length;
        int wordlen = words[0].length();
        HashMap<String,Integer> freq = new HashMap<>();
        for(String word : words){
            freq.put(word,freq.getOrDefault(word,0)+1);
        }
        for(int i = 0 ; i <= s.length()-totalwords*wordlen;i++){
            HashMap<String,Integer> seen = new HashMap<>();
            for(int j = 0 ; j < totalwords ; j++){
                int wordIndex = i + j*wordlen;
                String str = s.substring(wordIndex,wordIndex+wordlen);
                if(!freq.containsKey(str)) break;
                
                 seen.put(str,seen.getOrDefault(str,0)+1);
                if(freq.get(str)<seen.get(str)) break;
                
                if(j+1==totalwords){
                    res.add(i);
                }
            }
        }
        return res;
    }
}