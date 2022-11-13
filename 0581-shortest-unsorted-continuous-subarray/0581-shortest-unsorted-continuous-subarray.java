class Solution {
    public int findUnsortedSubarray(int[] nums) {
       int[] orignal = new int[nums.length];
       for(int i = 0; i < nums.length ; i++) orignal[i] = nums[i];
       Arrays.sort(nums);
      int left = nums.length;
      int right = 0;
      for(int i = 0 ; i < orignal.length ;i++){
        int a  = orignal[i];
        int b = nums[i];
        if(a!=b){
          left = Math.min(i,left);
          right = Math.max(i,right);
        }
      }
      return left<right?right-left+1:0;
    }
}