class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int ar) {
        int ans = 0;
        int[] diff = new int[rocks.length];
        for(int i=0  ; i < rocks.length ; i++){
            diff[i] = capacity[i] - rocks[i];
        }
        Arrays.sort(diff);
        int i = 0;
        while(ar>0&&i<rocks.length){
             ar-=diff[i];
            if(ar<0) break;
            ans++;
           i++;
        }
        
        return ans;
    }
}