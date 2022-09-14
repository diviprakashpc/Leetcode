class Solution {
    public int closedIsland(int[][] grid) {
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
                if(!visited[i][j]&&grid[i][j]==0){
                    if(i==0||i==grid.length-1||j==0||j==grid[0].length-1){
                          dfs(i,j,grid,visited);
                    }
                }
            }
        }
         for(int i = 0 ; i < grid.length ; i++){
            for(int j = 0 ; j < grid[0].length ; j++){
                if(!visited[i][j]&&grid[i][j]==0){
                    dfs(i,j,grid,visited);
                    noOfClosedIslands++;
                }
            }
        }
        return noOfClosedIslands;

    }
    
    public boolean isValid(int sr , int sc , int[][] grid,boolean[][] visited){
        return !(sr<0||sr>=grid.length||sc<0||sc>=grid[0].length||visited[sr][sc]);
    }
    
    public void dfs(int sr , int sc , int[][] grid , boolean[][] visited){
        if(sr<0||sr>=grid.length||sc<0||sc>=grid[0].length||visited[sr][sc]||grid[sr][sc]==1) return;
        visited[sr][sc] = true;
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        
        for(int i = 0 ; i < dirs.length ; i++){
            dfs(sr+dirs[i][0],sc+dirs[i][1],grid,visited);
        }
    }
    

}