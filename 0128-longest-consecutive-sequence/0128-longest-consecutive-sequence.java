class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
      for(int i : nums) set.add(i);
      int ans = 0;
      for(Integer i : set){
         if(set.contains(i-1)) continue;
         int l = 0;
         while(set.contains(i)){
           l++;
           i++;
         }
         ans = Math.max(ans,l);
      }
      return ans;
    }
}