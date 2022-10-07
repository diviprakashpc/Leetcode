class MyCalendarThree {
      TreeMap<Integer,Integer> map;
      int max;
    public MyCalendarThree() {
        map  = new TreeMap<>();
      max = 0;
    }
    
    public int book(int start, int end) {
        map.put(start,map.getOrDefault(start,0)+1);
        map.put(end,map.getOrDefault(end,0)-1);
        int sum = 0;
        for(Integer i : map.keySet()){
          sum+=map.get(i);
          max = Math.max(sum,max);
        }
      
      return max;
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */