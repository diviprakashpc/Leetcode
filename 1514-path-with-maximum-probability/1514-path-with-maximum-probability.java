class Solution {
     int maxp = 0;
    public double maxProbability(int n, int[][] edges, double[] prob, int start, int end) {
        List<List<Pair>> graph = new ArrayList<>();
        for(int i = 0 ; i < n  ; i++){
          graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i <edges.length ; i++){
          int u = edges[i][0];
          int v = edges[i][1];
          graph.get(u).add(new Pair(v,prob[i]));
          graph.get(v).add(new Pair(u,prob[i]));
        }
       
      double[] pr = new double[n];
      pr[start] = 1.00;
      Queue<Pair> q = new LinkedList<>();
      q.add(new Pair(start,1.00));
      while(!q.isEmpty()){
        Pair p = q.remove();
        for(Pair nbr : graph.get(p.val)){
              if(pr[nbr.val]<pr[p.val]*nbr.wt){
                pr[nbr.val] = pr[p.val]*nbr.wt;
                  q.add(new Pair(nbr.val,pr[p.val]*nbr.wt));
              }
        }
      }
      
       return pr[end];
      
    }
  
  static class Pair{
    int val;
    double wt;
    Pair(int val ,double wt){
        this.val = val;
        this.wt = wt;
    }
  }
}