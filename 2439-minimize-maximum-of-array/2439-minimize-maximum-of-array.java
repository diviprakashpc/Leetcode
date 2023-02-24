class Solution {
    public int minimizeArrayValue(int[] nums) {
        int l = 0;
        int maxi = nums[0];
        for(int i : nums) maxi = Math.max(maxi,i);
        int h = maxi + 1;
        int ans = Integer.MAX_VALUE;
        while(l<=h){
            int m = l + (h-l)/2;
            if(ok(nums,m)){
                h = m - 1;
                ans = Math.min(m,ans);
            }else{
                l = m + 1;
            }
        }
        return ans;
    }
    
    public boolean ok(int[] nums , int m){
       long s = 0;
        for(int i = 0 ; i < nums.length ; i++){
            s+=(m - nums[i]);
            if(s<0){
                return false;
            }
            
        }
        return true;
    }
}