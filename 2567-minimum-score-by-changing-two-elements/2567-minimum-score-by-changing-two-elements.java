class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int t1 = Math.abs(nums[2]-nums[n-1]);
        int t2 = Math.abs(nums[1]-nums[n-2]);
        int t3 = Math.abs(nums[0]-nums[n-3]);
        return Math.min(t1,Math.min(t2,t3));
    }
}