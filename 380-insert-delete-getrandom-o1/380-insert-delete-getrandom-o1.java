class RandomizedSet {
    HashSet<Integer> hs;
  int i;
    public RandomizedSet() {
        hs = new HashSet<>();
       i = 0;
    }
    
    public boolean insert(int val) {
        if(hs.contains(val)) return false;
        hs.add(val);
      return true;
    }
    
    public boolean remove(int val) {
        if(hs.contains(val)){
          hs.remove(val);
          return true;
        }
      return false;
    }
    
    public int getRandom() {
       int pos =getRandomInt(hs.size());
      int cnt = 0;
      for(int i : hs){
         if(cnt==pos) return i;
         cnt++;
      }
      return -1;
    }
  
    public int getRandomInt(int max) {
      return (int)Math.floor(Math.random() * max);
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */