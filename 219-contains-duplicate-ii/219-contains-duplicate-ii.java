class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k==0) return false;
        
     HashMap<Integer,Integer> map = new HashMap<>();
        k+=1;
        int i = 0;
        for( int j = 0; j < k&&j<nums.length ; j++){
            if(!map.containsKey(nums[j])){
                map.put(nums[j],j);
            }
            else if(map.containsKey(nums[j])&&map.get(nums[j])>=i){
                return true;
            }
            else map.put(nums[j],j);
        }
        
         i = 1;
        int j = k;
        while(j<nums.length){
            if(!map.containsKey(nums[j])){
                map.put(nums[j],j);
            }else if(map.containsKey(nums[j])&&map.get(nums[j])>=i){
                return true;
            }else{
                map.put(nums[j],j);
            }
            i++;
            j++;
        }
        
        return false;
        
        
        
        
    }
}