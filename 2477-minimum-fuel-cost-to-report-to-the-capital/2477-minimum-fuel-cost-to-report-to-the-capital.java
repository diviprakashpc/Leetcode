class Solution {
     Map<Integer,Integer> stn;
    public long minimumFuelCost(int[][] roads, int seats) {
        stn =  new HashMap<>();
        int n = roads.length + 1;
        
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
        for(int[] road : roads){
            int u = road[0];
            int v = road[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
     
        }
        int nodes = dfs(graph,0,new boolean[n]);
        long res = 0;
        for(int i = 1 ; i <n ; i++){
            res+=(Math.ceil((double)stn.get(i)/(double)seats));
        }
        return res;
    }
    
    public int dfs(List<List<Integer>> graph, int src , boolean[] visited){
         visited[src] = true;
         int cnt = 1;
        for(Integer nbr : graph.get(src)){
            if(!visited[nbr]){
                cnt+=dfs(graph,nbr,visited);
            }
        }
        stn.put(src,cnt);
        return cnt;
    }
}