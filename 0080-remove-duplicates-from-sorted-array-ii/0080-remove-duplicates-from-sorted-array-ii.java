class Solution {
    public int removeDuplicates(int[] nums) {
        int breaker = 2;
        int j = 2;
        int n = nums.length;
        while(j < n){
            int x = nums[breaker-2];
            if(nums[j]==x){
                j++;
            }else{
                nums[breaker] = nums[j];
                breaker++;
                j++;
            }
        }
        return breaker;
    }
}

//Took help from aayushi sharma youtube.