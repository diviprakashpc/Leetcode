class Solution {
    public String longestNiceSubstring(String s) {
        if(s.length()<=1) return "";
        Set<Character> set = new HashSet<>();
        for(int i =0 ; i < s.length() ; i++){
            set.add(s.charAt(i));
        }
        
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
           if(set.contains(Character.toUpperCase(ch))&&set.contains(Character.toLowerCase(ch))) continue;
            else{
                String prev = longestNiceSubstring(s.substring(0,i));
                String next = longestNiceSubstring(s.substring(i+1));
                return (prev.length()>=next.length()) ? prev : next;
            }
           
        }
         return s;
    }
}