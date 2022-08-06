class Solution {
    public int peakIndexInMountainArray(int[] arr) {
         int start = 0;
         int end = arr.length-1;
        while(start<=end){
            int mid = start + (end-start)/2;
            int x = (mid>0&&mid<arr.length-1) ? arr[mid-1] : -1;
            int y = (mid>0&&mid<arr.length-1) ? arr[mid+1] : -1;
        
            if(x!=-1&&y!=-1){
                if(arr[mid]>x&&arr[mid]>y){
                    return mid;
                }
                else if(arr[mid]<x&&arr[mid]>y){
                    end = mid -1;
                }
                else{
                    start = mid + 1;
                }
            }
            else if(x==-1){
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return -1;
    }
}