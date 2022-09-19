class Solution {
    static int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        for(int j = 0 ; j < n ; j++){
            dfs(heights,0,j,Integer.MIN_VALUE,pacific);
            dfs(heights,m-1,j,Integer.MIN_VALUE,atlantic);
        }
        
        for(int i = 0 ; i < m ; i++){
            dfs(heights,i,0,Integer.MIN_VALUE,pacific);
            dfs(heights,i,n-1,Integer.MIN_VALUE,atlantic);
        }
        
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0 ; i  < m ; i++){
            for(int j = 0 ; j <  n ; j++){
                if(pacific[i][j]&&atlantic[i][j]){
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    ans.add(temp);
                }
            }
        }
        return ans;
        
        
    }
    
    public void dfs(int[][] heights,int i,int j , int prev ,boolean[][] ocean){
        if(i<0||j<0||i>=heights.length||j>=heights[0].length) return;
        if(heights[i][j]<prev||ocean[i][j]) return;
        ocean[i][j] = true;
        for(int[] direction : dirs){
            int xdash = i + direction[0];
            int ydash = j + direction[1];
            dfs(heights,xdash,ydash,heights[i][j],ocean);
        }
    }
}