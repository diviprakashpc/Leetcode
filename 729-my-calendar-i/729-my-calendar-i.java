class MyCalendar {
      TreeMap<Integer,Integer> map;
    public MyCalendar() {
        map = new TreeMap<>();
    }
    
    public boolean book(int start, int end) {
        Integer ceil = map.ceilingKey(start);
        Integer floor = map.floorKey(start);
      //System.out.println("ceil and floor of " + start +" is "+ceil+" "+floor);
        if(ceil!=null){
           if(end>ceil) return false;
        }
        if(floor!=null){
          if(map.get(floor)>start) return false;
        }
       map.put(start,end);
      return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */