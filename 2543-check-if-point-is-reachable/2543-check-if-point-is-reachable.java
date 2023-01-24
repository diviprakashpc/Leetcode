class Solution {
    public boolean isReachable(int targetX, int targetY) {
        return Integer.bitCount(gcd(targetX, targetY)) == 1;
    }
    private int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}