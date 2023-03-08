class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = -1;
        // for(int pile : piles){
        //     max = Math.max(pile,max);
        // }
        int start = 1;
        int end = Integer.MAX_VALUE;
        int ans = 0;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(check(mid,piles,h)){
                ans = mid;
                end = mid-1;
            }
            else start = mid+1;
        }
        return ans;
    }
    
    public boolean check(int mid , int[] nums , int hr){
        for(int i = 0 ; i < nums.length ; i++){
            hr-=((nums[i]/mid)+1);
            if(nums[i]%mid==0) hr++;
        }
        return hr>=0;
    }
}