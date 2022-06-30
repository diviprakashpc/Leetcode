class Solution {
    public int makeConnected(int n, int[][] connections) {
        int edges = connections.length;
        if(edges<n-1) return -1;
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < edges ; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
       int compo = 0;
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
                dfs(n,i,graph,visited);
                compo++;
            }
        }
        return compo-1;
        
    }
    
    public void dfs(int n ,int src,ArrayList<ArrayList<Integer>> graph,boolean[] visited){
        visited[src] = true;
        for(Integer i : graph.get(src)){
            if(!visited[i]){
               dfs(n,i,graph,visited);
            }
        }
        
    }
}