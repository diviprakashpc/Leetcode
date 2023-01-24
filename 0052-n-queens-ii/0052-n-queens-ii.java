class Solution {
    int ans;
    public int totalNQueens(int n) {
        ans = 0;
        boolean[][] visited = new boolean[n][n];
         helper(visited,0,0,n);
        return ans;
    }
    
    public void helper(boolean[][] visited , int r , int c,int n){
        if(r==n){
            ans++;
            return;
        }
       
        for(int j = 0 ; j < n ; j++){
             if(isOk(visited,r,j)){
                visited[r][j] = true;
                helper(visited,r+1,j,n); 
                 visited[r][j] = false;
             }
        }
        
       
        return;
    }
    
       public boolean isOk(boolean[][] chess , int row , int col){
        for(int i = row, j = col ; i>=0 ; i--){
            if(chess[i][j]==true) return false;
        }
        
        for(int i = row , j = col ; i>=0&& j>=0 ; i--,j--){
            if(chess[i][j]==true) return false;
        }
        for(int i = row , j = col ; i>=0&& j<chess.length ; i--,j++){
            if(chess[i][j]==true) return false;
        }
        
        return true;
    }
}