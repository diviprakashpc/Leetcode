class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
         boolean[] visited = new boolean[edges.length+1];
        for(int i = 0 ; i < edges.length+1 ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            Arrays.fill(visited,false);
             graph.get(edges[i][0]).add(edges[i][1]);
            graph.get(edges[i][1]).add(edges[i][0]);
            if(helper(graph,visited,-1,edges[i][0])){
                int[] ans = new int[2];
                ans[0] = edges[i][0];
                    ans[1] = edges[i][1];
                return ans;
            }        }
        return new int[2];
    }
    
    public boolean helper(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int parent, int src){
        
        visited[src] = true;
        
        for(Integer i : graph.get(src)){
            if(!visited[i]){
                helper(graph,visited,src,i);
            }else if(i!=parent){
                return true;
            }
        }
        return false;
        
    }
}