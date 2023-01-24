class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cs = 0;
        int ans = 0;
        HashMap<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
      
        int n = nums.length;
        for(int i = 0 ; i < n ;i++){
            cs+=nums[i];
            if(map.containsKey(cs-goal)){
                ans+=map.get(cs-goal);
            }
            map.put(cs,map.getOrDefault(cs,0)+1);
        }
        return ans;
    }
}