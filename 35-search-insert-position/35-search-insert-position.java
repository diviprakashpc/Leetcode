class Solution {
    public int searchInsert(int[] arr, int target) {
        int l = 0;
        int h = arr.length - 1;
        int ans = arr.length;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(arr[mid]==target) return ans = mid;
            else if(arr[mid]>target){
                ans = mid;
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
}