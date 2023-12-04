class Solution {
    public boolean containsDuplicate(int[] nums) {
       Set<Integer> set = new HashSet<>();
        for(int i : nums) set.add(i);
        boolean ans =  set.size()!=nums.length;
        return ans;
    }
}