class Solution {
  
  static class Tuple implements Comparable<Tuple>{
    int x;
    int y;
    double d;
    Tuple(int x,  int y){
      this.x = x;
      this.y = y;
      this.d = Math.sqrt(x*x + y*y);
    }
    
    public int compareTo(Tuple t){
      if(this.d < t.d) return -1;
      else if(this.d >= t.d) return +1;
      else return 0;
    }
  }
  
  public int[][] kClosest(int[][] points, int k) {
        
    int[][] res = new int[k][2];
    PriorityQueue<Tuple> pq = new PriorityQueue<>();
    for(int[] point : points){
       int x = point[0];
       int y = point[1];
       Tuple t = new Tuple(x,y);
       pq.add(t);
    }
    
    int idx = 0;
    for(int i = 0 ; i < k ; i++){
      Tuple rm = pq.remove();
      res[i][0] = rm.x;
      res[i][1] = rm.y;
    }
    return res;
    
    }
}