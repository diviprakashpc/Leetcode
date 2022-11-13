class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        boolean flag = false;
       for(int i = 1; i < nums.length ; i++){
         if(nums[i]<nums[i-1]){
           flag = true;
         }
          if(flag) min = Math.min(min,nums[i]);
       }
        flag = false;
       for(int i = nums.length-2; i>=0 ; i--){
         if(nums[i]>nums[i+1]) flag = true;
         if(flag) max = Math.max(max,nums[i]);
       }
       int left = nums.length;
       int right = 0;
       for(int i = 0 ; i < nums.length ; i++){
         if(nums[i]>min) {
           left = i;
           break;
         }
       }
      
       for(int i = nums.length-1; i >=0 ;i--){
         if(nums[i]<max) {
           right = i;
           break;
         }
       }
      return left<right ? right-left+1 : 0;
    }
}