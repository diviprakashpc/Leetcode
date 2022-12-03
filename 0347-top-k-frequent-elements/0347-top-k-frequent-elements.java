class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int i = 0 ; i < nums.length ; i++){
        map.put(nums[i],map.getOrDefault(nums[i],0)+1);
      } 
      
      List<Integer>[] buckets = new List[nums.length+1];
      
      for(int key : map.keySet()){
         int idx = map.get(key);
         if(buckets[idx]==null) buckets[idx] = new LinkedList<>();
         buckets[idx].add(key);
      }
      int[] res = new int[k];
      int idx = 0;
      for(int i = buckets.length-1 ; i>=0 ; i--){
           if(buckets[i]==null) continue;
           boolean full = false;
           while(buckets[i].size()!=0){
             if(idx==k) {
               full = true;
               break;
             }
              res[idx++] = buckets[i].remove(buckets[i].size()-1);
           }
        if(full) break;
      }
        return res;
      }  
  
}