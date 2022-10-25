class Solution {
    public int longestConsecutive(int[] nums) { 
      if(nums.length==0) return 0;
      HashMap<Integer,Boolean> map = new HashMap<>();
      for(int i : nums){
        map.put(i,true);
      }
      for(int key : nums){
        if(map.containsKey(key-1)) map.put(key,false);
      }
     
      int ans = 1;
      for(int key : nums){
        int len = 1;
        int start = key;
        while(map.get(key)&&map.containsKey(start+1)) {
         
          start++;
          len++;
        }
        ans = Math.max(ans,len);
      }
      return ans;
    }
}