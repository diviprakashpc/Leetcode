class Solution {
    int[] parent;
    int[] discovery;
    int[] low;
    int time;
    List<List<Integer>> bridges;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        parent = new int[n];
        discovery = new int[n];
        low = new int[n];
        time = 0;
        bridges = new ArrayList<>();
        boolean[] visited = new boolean[n];
        parent[0] = -1;
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            graph.add(new ArrayList<>());
        }
        for(int i = 0 ; i < connections.size() ; i++){
            int u = connections.get(i).get(0);
            int v = connections.get(i).get(1);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        dfs(n,0,graph,visited);
        return bridges;
    }
    
    public void dfs(int n ,int u, List<List<Integer>> graph,boolean[] visited){
        visited[u] = true;
        discovery[u] = time;
        low[u] = time;
        time++;
        for(Integer v : graph.get(u)){
            if(v==u) continue;
            if(parent[u]==v&&visited[v]) continue;
            else if(visited[v]){
                low[u] = Math.min(low[u],discovery[v]);
            }
            else{
                parent[v] = u;
                dfs(n,v,graph,visited);
                low[u] = Math.min(low[u],low[v]);
                if(discovery[u]<low[v]){
                    List<Integer> bridge = new ArrayList<>();
                    bridge.add(u);
                    bridge.add(v);
                    bridges.add(bridge);
                }
            }
        }
    }
}