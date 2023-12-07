class Solution {
    public int findMin(int[] nums) {
        int ans = getPivot(nums);
        if(ans==-1) return nums[0];
        return nums[ans+1];
    }
    
    public int getPivot(int[] nums){
        int n = nums.length;
        int pivot = -1;
        int l = 0;
        int h = n-1;
        while(l<=h){
            int mid = (l+h)/2;
            int x = nums[mid];
            if(mid!=l&&nums[mid-1]>x){
                return mid-1;
            }else if(mid!=h&&nums[mid+1]<x){
                return mid;
            }else{
                if(nums[0]>x){
                    h = mid-1;
                }else {
                    l = mid+1;
                }
            }
        }
      //  System.out.println(pivot);
        return pivot;
    }
}