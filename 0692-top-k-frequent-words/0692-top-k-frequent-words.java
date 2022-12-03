class Solution {
    public List<String> topKFrequent(String[] words, int k) {
         
      HashMap<String,Integer> map = new HashMap<>();
      for(int i = 0 ; i < words.length ; i++){
        map.put(words[i],map.getOrDefault(words[i],0)+1);
      } 
      
      List<String>[] bucket = new List[words.length+1];
      
      for(String key : map.keySet()){
         int idx = map.get(key);
         if(bucket[idx]==null) bucket[idx] = new LinkedList<>();
         insertion(bucket,idx,key);
      }
      // System.out.println(map);
      // for(int i = 0 ; i < bucket.length ; i++){
      //   System.out.println(i+" -> "+bucket[i]);
      // }
      
      List<String> res = new ArrayList<>();
      
      for(int i = bucket.length-1 ; i>=0 ; i--){
           if(bucket[i]==null) continue;
           boolean full = false;
           while(bucket[i].size()!=0){
             if(res.size()==k) {
               full = true;
               break;
             }
              res.add(bucket[i].remove(0));
           }
        if(full) break;
      }
        return res;
    }
  
   public void insertion(List<String>[] bucket , int idx , String s1 ){
       List<String> list = bucket[idx];
       int iterator = 0;
      if(list.size()==0) {
        list.add(s1);
        return;
      }
       while(iterator<list.size()){
         String s2 = list.get(iterator);
         if(s1.compareTo(s2)<0){
            list.add(iterator,s1);
           break;
         }else{
           iterator++;
         }
       }
      if(iterator==list.size()) list.add(s1);
     return;
   }
}