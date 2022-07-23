class Solution {
    public long countSubarrays(int[] nums, long k) {
        if(k==0) return 0;
        long count = 0;
        int i = 0;
        long sum = 0;
        for(int j =0 ;  j < nums.length ; j++){
            sum += nums[j];
            long score = sum * (j-i+1);
            while(score>=k){
                sum-=nums[i];
                i++;
                score = sum*(j-i+1);
            }
            count+=(j-i+1);
        }
        return count;
    }
}



  
  