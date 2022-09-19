class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n ; i++) graph.add(new ArrayList<>());
        for(int[] row : edges){
            int u = row[0];
            int v = row[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        dfs(graph,source,destination,visited);
        
        return (visited[destination]);
    }
    
    public void dfs(ArrayList<ArrayList<Integer>> graph, int source, int dest, boolean[] visited){
        if(visited[source]) return;
        visited[source] = true;
        for(Integer i: graph.get(source)){
            if(!visited[i]) dfs(graph,i,dest,visited);
        }
    }
}