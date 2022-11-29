class RandomizedSet {
       
  HashMap<Integer,Integer> hm;
  List<Integer> list;     
    public RandomizedSet() {
        hm = new HashMap<>();
        list = new ArrayList<>();
    }
    
    public boolean insert(int val) {
        if(hm.containsKey(val)) return false;
        list.add(val);
        hm.put(val,list.size()-1);
        return true;
    }
    
    public boolean remove(int val) {
        if(!hm.containsKey(val)) return false;
        int idx = hm.get(val);
        int size = list.size();
        int temp = list.get(size-1);
        list.set(size-1,val);
        list.set(idx,temp);
        hm.put(temp,idx);
        hm.remove(val);
        list.remove(size-1);
        return true;
    }
    
    public int getRandom() {
        double rand = Math.random();
        double idx = rand * list.size();
        return list.get((int)Math.floor(idx));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */