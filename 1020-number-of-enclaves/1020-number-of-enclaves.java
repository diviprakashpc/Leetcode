class Solution {
    public int numEnclaves(int[][] grid) {
      boolean[][] visited = new boolean[grid.length][grid[0].length];
        // for(int i = 0 ; i < grid.length ; i++){
        //     for(int j = 0 ; j < grid[0].length ; j++){
        //         System.out.print(grid[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        int noOfClosedIslands = 0;
        for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    if(i==0||i==grid.length-1||j==0||j==grid[0].length-1){
                          dfs(i,j,grid,visited);
                    }
                }
            }
        }
        int count = 0;
         for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!visited[i][j]&&grid[i][j]==1){
                    count++;
                }
            }
        }
        return count;
  
    }
    public boolean isValid(int sr , int sc , int[][] grid,boolean[][] visited){
        return !(sr<0||sr>=grid.length||sc<0||sc>=grid[0].length||visited[sr][sc]);
    }
    
    public void dfs(int sr , int sc , int[][] grid , boolean[][] visited){
       
        visited[sr][sc] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i = 0 ; i < dirs.length ; i++){
        if(isValid(sr+dirs[i][0],sc+dirs[i][1],grid,visited)&&grid[sr+dirs[i][0]][sc+dirs[i][1]]==1) {
         
            dfs(sr+dirs[i][0],sc+dirs[i][1],grid,visited);
        }
        }
    }
}