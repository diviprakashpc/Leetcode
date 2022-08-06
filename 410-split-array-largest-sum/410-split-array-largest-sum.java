class Solution {
    public int splitArray(int[] nums, int m) {
        int max = Integer.MIN_VALUE;
        int sum = Arrays.stream(nums).sum();
        for(int i : nums){
            max = Math.max(max,i);
        }
        int start = max;
        int end = sum;
        while(start<=end){
            int mid = start + (end-start)/2;
            if(m>=parts(nums,mid)) end = mid - 1;
            else if(m<parts(nums,mid)) start = mid + 1;
        }
        return start;
    }
    
    public int parts(int[] nums, int sum){
        int part = 0;
        int csum  =0;
        for(int i = 0 ; i < nums.length ; i++){
            csum +=nums[i];
            if(csum>sum){
                part++;
                csum = nums[i];
            }
        }
        part++;
        return part;
    }
}