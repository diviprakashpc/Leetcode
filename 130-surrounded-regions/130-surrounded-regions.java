class Solution {
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0 ; i < m ;i++){
            for(int j = 0 ; j < n ;j++){
                if(i*j==0||i==m-1||j==n-1){
                    if(!visited[i][j]) dfs(board,i,j,visited);
                }
            }
        }
        
        for(int i = 0 ; i < m ; i++){
            for(int j = 0 ; j < n ; j++){
                if(board[i][j]=='O'){
                    board[i][j] = 'X';
                }else if(board[i][j]=='1'){
                    board[i][j] = 'O';
                }
            }
        }
        return;
    }
    
    
    public void dfs(char[][] board, int i , int j,boolean[][] visited){
        if(i<0||j<0||i>=board.length||j>=board[0].length) return;
        if(visited[i][j]||board[i][j]=='X') return;
        visited[i][j] = true;
        board[i][j] = '1';
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int[] d : dirs){
                dfs(board,i+d[0],j+d[1],visited);
        }
    }
}