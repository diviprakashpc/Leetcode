class Solution {
    public int findCircleNum(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        int no_p = 0;
       for(int i = 0 ; i < edges.length ; i++){
         for(int j = 0 ; j < edges[0].length ; j++){
           if(!visited[j]&&edges[i][j]==1){
             dfs(edges,i,visited);
             no_p++;
           }
         }
       }
      return no_p;
    }
  
   public void dfs(int[][] edges , int src , boolean[] visited){
      visited[src] = true;
     for(int j = 0; j < edges[src].length ; j++){
         if(!visited[j]&&edges[src][j]==1){
           dfs(edges,j,visited);
         }
     }
   }
}