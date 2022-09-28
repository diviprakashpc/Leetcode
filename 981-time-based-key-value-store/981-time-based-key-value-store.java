class TimeMap {
     
    HashMap<String,List<Pair>> map;
    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(!map.containsKey(key)){
          map.put(key,new ArrayList<>());
        }
       Pair p = new Pair(value,timestamp);
       map.get(key).add(p);
    }
    
    public String get(String key, int timestamp) {
         if(!map.containsKey(key)) return "";
        Pair lbp = lower_bound(map.get(key),timestamp);
       if(lbp!=null)
        return lbp.value;
      return "";
    }
  
  
    public Pair lower_bound(List<Pair> list,int target){
       int start = 0;
       int end  = list.size()-1;
       int ans = -1;
       while(start<=end){
         int mid = start + (end-start)/2;
         if(list.get(mid).ts==target){
           return list.get(mid);
         }else if(list.get(mid).ts<target){
               ans = Math.max(ans,mid);
               start = mid + 1;
         }else{
              end = mid - 1;
         }
       }
       return (ans==-1) ? null : list.get(ans);
    }
  
    static class Pair{
      String value;
      int ts;
      Pair(String value , int ts){
        this.value = value;
        this.ts = ts;
      }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */