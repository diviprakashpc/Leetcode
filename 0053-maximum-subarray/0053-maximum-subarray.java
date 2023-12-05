class Solution {
    public int maxSubArray(int[] nums) {
        int cs = 0;
        int ms = nums[0];
        int n = nums.length;
        for(int i = 0; i < n ; i++){
            cs = cs + nums[i];
            ms = Math.max(cs,ms);
            if(cs<0){
                cs = 0;
            }
        }
        return ms;
    }
}