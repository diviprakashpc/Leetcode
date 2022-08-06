class Solution {
    public int search(int[] nums, int target) {
        int idx = findPivot(nums);
        if(idx==-1) {
            return binarySearch(nums,target,nums.length,false);
        }
        if(nums[idx]==target) return idx;
        int left = binarySearch(nums,target,idx,false);
        if(left!=-1) return left;
        int right = binarySearch(nums,target,idx,true);
        return right;
    }
    
    public int binarySearch(int[] arr , int target , int idx,boolean flag){
        int start = 0;
        int end = 0;
        if(flag){
            start = idx+1;
            end = arr.length-1;
        }
        else{ 
            start = 0;
           end = idx-1;
        }
        while(start<=end){
           int mid = start + (end-start)/2;
            if(target<arr[mid]){
                end = mid-1;
            }
            else if(target > arr[mid]){
                start = mid+1;
            }
            else{
                return mid;
            }
        }
         return -1;
    }
    
    
    public int findPivot(int[] nums){
        int start = 0;
        int end = nums.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
           if(mid<end&&nums[mid]>nums[mid+1]) return mid;
            else if(mid>0&&nums[mid]<nums[mid-1]) return mid-1;
            else{
                if(nums[mid]<nums[start]){
                    end = mid -1;
                }else{
                    start  = mid + 1;
                }
            }
        }
        return -1;
    }
}