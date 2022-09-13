class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int noOfIslands = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!visited[i][j]&&grid[i][j]=='1'){
                    dfs(i,j,visited,grid);
                    noOfIslands++;
                }
            }
        }
        return noOfIslands;
    }
    
    public void dfs(int sr ,int sc, boolean[][] vis,char[][] grid){
        if(sr<0||sr>=grid.length||sc<0||sc>=grid[0].length||grid[sr][sc]=='0') return;
        if(vis[sr][sc]) return;
        vis[sr][sc] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0 ; i < dirs.length ; i++){
            dfs(sr+dirs[i][0],sc+dirs[i][1],vis,grid);
        }
    }
}