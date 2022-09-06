class Solution {
    public int[] nextGreaterElements(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < nums.length ;i++){
            for(int j = (i+1)%nums.length ; ;j = (j+1)%nums.length){
                if(j==i) {
                    ans.add(-1);
                    break;
                }
                if(nums[j]>nums[i]){
                   ans.add(nums[j]);
                    break;
                }
            }
        }
        
        int[] res = new  int[nums.length];
        for(int i = 0 ; i < nums.length ; i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}