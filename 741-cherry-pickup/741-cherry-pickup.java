class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid.length][grid.length];
        int ans = helper(0,0,0,grid,dp);
       return (flag==true)?ans:0;
    }
    boolean flag = false;
    public int helper(int r1, int c1 , int r2,int[][] grid,int[][][] dp){
        int c2 = r1+c1-r2;
        if(r1>=grid.length||r2>=grid.length||c1>=grid[0].length||c2>=grid[0].length||grid[r1][c1]==-1||grid[r2][c2]==-1){
            return Integer.MIN_VALUE;
        }      
        
        if(r1==grid.length-1&&c1==grid[0].length-1){
            flag = true;
            return grid[r1][c1];
        }
        if(dp[r1][c1][r2]!=0) return dp[r1][c1][r2];
        int cherries = 0;
        if(r1==r2&&c2==c1)
            cherries+=grid[r1][c1];
        else cherries +=(grid[r1][c1]+grid[r2][c2]);
        
        int op1 = helper(r1+1,c1,r2+1,grid,dp);
        int op2  = helper(r1,c1+1,r2,grid,dp);
        int op3 = helper(r1+1,c1,r2,grid,dp);
        int op4 = helper(r1,c1+1,r2+1,grid,dp);
        
        cherries+=(Math.max(Math.max(op1,op2),Math.max(op3,op4)));
        return dp[r1][c1][r2]=cherries;
    }
    
}

