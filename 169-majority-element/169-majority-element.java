class Solution {
    public int majorityElement(int[] nums) {
        int currelem = nums[0];
        int count = 0;
        for(int i = 0 ; i < nums.length ; i++){
            if(count==0){
                currelem=nums[i];
            }
            if(nums[i]==currelem) count++;
            else if(nums[i]!=currelem) count--;
            
        }
        return currelem;
    }
}