class Solution {
    public int maxAreaOfIsland(int[][] grid) {
         boolean[][] visited = new boolean[grid.length][grid[0].length];
        int largestIsland = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    int[] length = new int[1];
                    length[0] = 1;
                    dfs(i,j,visited,grid,length);
                    largestIsland = Math.max(largestIsland,length[0]);
                    
                }
            }
        }
        return largestIsland;
    }
    
     public void dfs(int sr ,int sc, boolean[][] vis,int[][] grid,int[] len){
        vis[sr][sc] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0 ; i < dirs.length ; i++){
            int rowdash = sr+dirs[i][0];
            int coldash = sc + dirs[i][1];
            if(isValid(rowdash,coldash,vis,grid)){
                len[0]++;
                dfs(sr+dirs[i][0],sc+dirs[i][1],vis,grid,len);
            } 
        }
    }
    
    public boolean isValid(int sr , int sc , boolean[][] visited , int[][] grid){
         if(sr<0||sr>=grid.length||sc<0||sc>=grid[0].length||grid[sr][sc]==0||visited[sr][sc]) return false;
        return true;
    }
}