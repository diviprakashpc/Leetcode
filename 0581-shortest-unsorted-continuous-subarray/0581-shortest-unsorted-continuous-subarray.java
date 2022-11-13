class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int left = nums.length;
        int right = 0;
        for(int i = 0 ; i < nums.length ; i++){
          for(int j = i+1 ; j < nums.length ; j++){
            if(nums[i]>nums[j]){
               left = Math.min(i,left);
               right = Math.max(j,right);
            }
          }
        }
      return (left<right) ? right-left+1 : 0;
    }
}