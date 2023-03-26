class Solution {
    List<Integer> cSize;
    int curr = 0;
    public long countPairs(int n, int[][] edges) {
        cSize = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0 ; i < n  ; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        
        boolean[] visited = new boolean[n];
        
        for(int i = 0 ; i < n ; i++){
            if(!visited[i]){
              
               int sa =  dfs(graph,n,i,visited);
                cSize.add(sa);
            }    
        }
        long ans = 0;
        for(int i = 0 ; i < cSize.size() ; i++){
           long x = cSize.get(i)*1L;
           ans+=(x*(n*1L-x));
        }
        return ans/(2*1L);
    }
    
    
    public int dfs(List<List<Integer>> graph , int n , int src , boolean[] visited){
       visited[src] = true;
        int ans = 1;
        for(Integer nbr : graph.get(src)){
             if(!visited[nbr]){
                 visited[nbr] = true;
                 ans+=dfs(graph,n,nbr,visited);
             }
        }
        
        return ans;
    }
}