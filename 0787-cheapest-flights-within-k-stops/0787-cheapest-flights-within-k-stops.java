class Solution {
    class Pair implements Comparable<Pair>{
        int dist;
        int val;
        int stops;
        Pair(int d , int v,int s){
            dist = d;
            val = v;
            stops = s;
        }
        
        public int compareTo(Pair p){
            if(this.stops < p.stops) return -1;
            else if(this.stops>p.stops) return 1;
            else return this.dist - p.dist;
        }
        
    }
    
    class Node{
        int val;
        int wt;
        Node(int val , int wt){
            this.val = val;
            this.wt = wt;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Node>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) {
            graph.add(new ArrayList<>());
        }
        for(int[] flight : flights){
            int u = flight[0];
            int v = flight[1];
            int wt = flight[2];
            graph.get(u).add(new Node(v,wt));
        }
        int[] dist = djikstra(n,graph,src,dst,k);
     //   System.out.println(Arrays.toString(dist));
        return dist[dst]==Integer.MAX_VALUE?-1:dist[dst];
    }
    
    public int[] djikstra(int n , List<List<Node>> graph , int s , int d , int k){
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,s,-1));
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[s] = 0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            for(Node nbr : graph.get(p.val)){
                if(dist[nbr.val] > p.dist + nbr.wt&&p.stops+1<=k){
                    dist[nbr.val] = p.dist + nbr.wt;
                    pq.add(new Pair(dist[nbr.val],nbr.val,p.stops+1));
                }
            }
        }
        
        return dist;
    }
}