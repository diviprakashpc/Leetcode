class Solution {
    public int[] shuffle(int[] nums, int n) {
       int[] res = new int[nums.length];
       for(int i = 0 ; i < n ; i++) {
           res[2*i+1] = nums[n+i];
           res[2*i] = nums[i];
       }
        return res;
    }
}