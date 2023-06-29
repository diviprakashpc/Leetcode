class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> al = new ArrayList<>();
        int i = 0;
        int j = 0;
        int[] res = new int[nums.length];
        int k = 0;
        while(true){
            while(i<nums.length&&nums[i]<0) i++;
            if(i<nums.length) res[k++] = nums[i++];
            
             while(j<nums.length&&nums[j]>0) j++;
             if(j<nums.length) res[k++] = nums[j++];
            
             if(i>=nums.length&&j>=nums.length) break;
        }
      
        return res;
    }
}