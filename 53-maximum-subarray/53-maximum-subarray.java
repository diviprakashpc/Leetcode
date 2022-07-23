class Solution {
    public int maxSubArray(int[] nums) {
        int i = 0 ;
        int j =0 ; 
        int cs = 0;
        int ms = Integer.MIN_VALUE;
        while(j<nums.length){
            if(cs<0){
               cs = 0;
            }
            cs+=nums[j];
            ms = Math.max(cs,ms);
            j++;
        }
         ms = Math.max(cs,ms);
        return ms;
    }
}