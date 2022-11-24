class Solution {
  static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
   
  public int nearestExit(char[][] maze, int[] entrance) {
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[maze.length][maze[0].length];
        int er = entrance[0];
        int ec = entrance[1];
        if(maze[er][ec]=='+') return -1;
        q.add(new Pair(er,ec,0));
        while(!q.isEmpty()){
           int size = q.size();
           while(size-->0){
             Pair p = q.remove();
             if(isBoundaryAndNotOrignal(p,er,ec,maze)){
               return p.steps;
             }
             vis[p.row][p.col] = true;
             for(int i = 0 ; i < dirs.length ; i++){
                int rdash = p.row + dirs[i][0];
                int cdash = p.col + dirs[i][1];
                if(rdash<0||cdash<0||rdash==maze.length||cdash==maze[0].length||vis[rdash][cdash]||maze[rdash][cdash]=='+')                 continue;
                q.add(new Pair(rdash,cdash,p.steps+1));
                maze[rdash][cdash] = '+';
             }
           //  vis[p.row][p.col] = false;
           }
        }
    return -1;
    }
  
  public boolean isBoundaryAndNotOrignal(Pair p , int er, int ec, char[][] maze){
     if(p.row==er&&p.col==ec) return false;
     if(p.row==maze.length-1||p.col==maze[0].length-1||p.row==0||p.col==0) return true;
    return false;
  }
  
  static class Pair{
     int row;
     int col;
     int steps;
    Pair(int r , int c , int s){
      row = r;
      col = c;
      steps = s;
    }
  }
}