class Solution {
    public int searchInsert(int[] nums, int target) {
        return search(nums,target);
    }
    
    public int search(int[] nums, int tgt){
        int ans = 0;
        int l = 0;
        int r = nums.length-1;
        while(l<=r){
            int m = (l+r)/2;
            if(nums[m]==tgt) return m;
            else if(nums[m]>tgt){
                r = m - 1;
            }else l = m + 1;
        }
        
        return l;
    }
}