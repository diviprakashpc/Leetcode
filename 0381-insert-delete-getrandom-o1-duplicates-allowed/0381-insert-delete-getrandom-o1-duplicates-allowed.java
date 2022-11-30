class RandomizedCollection {
 
  List<Integer> list;
  Map<Integer,HashSet<Integer>> map; // list of index 
    public RandomizedCollection() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }
    
    public boolean insert(int val) {
       boolean flag = !map.containsKey(val);
       list.add(val); 
       int n_idx = list.size()-1;
       map.putIfAbsent(val,new HashSet<>());
       map.get(val).add(n_idx);
       return flag;
    }
    
    public boolean remove(int val) {
       if(!map.containsKey(val)) return false;
       HashSet<Integer> indexes = map.get(val);
       int idx_to_be_removed = indexes.iterator().next();
       indexes.remove(idx_to_be_removed);
       if(indexes.size()==0) map.remove(val);
       int size = list.size();
       int lastVal = list.get(size-1);
       int lastValIdx = size-1;
       if(lastValIdx!=idx_to_be_removed){
         list.set(idx_to_be_removed,lastVal);
       HashSet<Integer> lastValSet = map.get(lastVal);
       lastValSet.remove(lastValIdx);
       lastValSet.add(idx_to_be_removed);
      
       }
        list.remove(list.size()-1);
       return true;
    }
  
    public int getRandom() {
        double rand = Math.random();
        double idx = rand * list.size();
        return list.get((int)Math.floor(idx));
    }
}

/**
 * Your RandomizedCollection object will be instantiated and called as such:
 * RandomizedCollection obj = new RandomizedCollection();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */