class Solution {
    public int singleNonDuplicate(int[] nums) {
        if(nums.length==1) return nums[0];
        int start = 0;
        int end = nums.length-1;
        while(start<=end){            
            int mid = start + (end-start)/2;
            if(mid==0||mid==nums.length-1) return nums[mid];
            if(nums[mid]==nums[mid-1]){
                int wd = mid + 1;
                if(wd%2==0){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            else if(nums[mid]==nums[mid+1]){
                int wd = nums.length - mid ;
                if(wd%2==0){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
            else return nums[mid];
        }
        return nums[start];
    }
}