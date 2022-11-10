class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;  i < nums.length ; i++){
                if(map.containsKey(target-nums[i])){
                    int[] arr = new int[2];
                    arr[0] = i;
                    arr[1] = map.get(target-nums[i]);
                    return arr;
                }
            else{
                map.put(nums[i],i);
            }
        }
        
        return new int[2];
    }
}