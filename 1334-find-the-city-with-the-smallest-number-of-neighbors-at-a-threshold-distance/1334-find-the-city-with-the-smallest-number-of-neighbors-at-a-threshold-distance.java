class Solution {
    public int findTheCity(int n, int[][] edges, int th) {
      int[] citiesConnected = new int[n];
      List<List<Pair>> graph = new ArrayList<>();
      for(int i = 0 ; i < n  ; i++){graph.add(new ArrayList<>());}
       for(int i = 0 ; i < edges.length ; i++){
         int u = edges[i][0];
         int v  = edges[i][1];
         int wt = edges[i][2];
         graph.get(u).add(new Pair(v,wt));
         graph.get(v).add(new Pair(u,wt));
       }
        for(int i = 0 ; i < n  ; i++){
          int[] dist = new int[n];
          Arrays.fill(dist,Integer.MAX_VALUE);
          djikstra(graph,i,dist);
          for(int j = 0 ; j < n ; j++){
            if(dist[j]<=th) citiesConnected[i]++;
          }
        }
      int minConnection = Integer.MAX_VALUE;
      int city = -1;
      for(int i = 0 ; i < citiesConnected.length ; i++){
        if(citiesConnected[i]<=minConnection){
          minConnection = citiesConnected[i];
          city = i;
        }
      }
      return city;
    }
  
   public void djikstra(List<List<Pair>> graph , int src,int[] dist){
     PriorityQueue<Pair> pq  = new PriorityQueue<>();
     dist[src] = 0;
     pq.add(new Pair(src,0));
     while(!pq.isEmpty()){
       Pair p = pq.remove();
       for(Pair nbr : graph.get(p.val)){
          if(dist[nbr.val]>dist[p.val] + nbr.wt){
            dist[nbr.val] = dist[p.val]+nbr.wt;
            pq.add(new Pair(nbr.val,dist[nbr.val]));
          }
       }
     }
   }
  
  
  static class Pair implements Comparable<Pair>{
    int val;
    int wt;
    Pair(int val, int wt){
      this.val = val;
      this.wt = wt;
    }
    @Override
    public int compareTo(Pair p){
      return this.wt - p.wt;
    }
  }
}