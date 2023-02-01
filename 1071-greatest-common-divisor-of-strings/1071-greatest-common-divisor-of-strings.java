class Solution {
    public String gcdOfStrings(String s1, String s2) {
        if(!((s1+s2).equals(s2+s1))) return "";
        return s1.substring(0,gcd(s1.length(),s2.length()));
    }
    
    public int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }
}