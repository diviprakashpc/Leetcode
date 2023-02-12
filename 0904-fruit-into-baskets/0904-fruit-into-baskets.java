class Solution {
    public int totalFruit(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int i = 0;
        int j = 0;
        int ans = 0;
        while(j < nums.length){
            map.put(nums[j],map.getOrDefault(nums[j],0)+1);
            if(map.size()<=2){
                ans = Math.max(ans,j-i+1);
            }else{
                 while(map.size()>2){
                      map.put(nums[i],map.getOrDefault(nums[i],0)-1);
                     if(map.get(nums[i])==0) map.remove(nums[i]);
                     i++;
                 }
                 ans = Math.max(ans,j-i+1);
            }
            j++;
        }
        return ans;
    }
}