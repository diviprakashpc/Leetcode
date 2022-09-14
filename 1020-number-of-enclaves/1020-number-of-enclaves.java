class Solution {
    public int numEnclaves(int[][] grid) {
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j]==1){
                    if(i==0||i==grid.length-1||j==0||j==grid[0].length-1){
                          dfs(i,j,grid);
                    }
                }
            }
        }
        int count = 0;
         for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
    }
    public boolean isValid(int sr , int sc , int[][] grid){
        return !(sr<0||sr>=grid.length||sc<0||sc>=grid[0].length||grid[sr][sc]==0);
    }
    
    public void dfs(int sr , int sc , int[][] grid){
        grid[sr][sc] = 0;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i = 0 ; i < dirs.length ; i++){
        if(isValid(sr+dirs[i][0],sc+dirs[i][1],grid)) {
            dfs(sr+dirs[i][0],sc+dirs[i][1],grid);
        }
        }
    }
}