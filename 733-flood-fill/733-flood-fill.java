class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        Queue<Tuple> q = new LinkedList<>();
        int orgcolor = image[sr][sc];
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        q.add(new Tuple(sr,sc));
        image[sr][sc] = color;
        int level = 0;
        
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            while(size-->0){
                Tuple t = q.remove();
                for(int i = 0 ; i < dirs.length ; i++){
                    int rowdash = t.row + dirs[i][0];
                    int coldash = t.col + dirs[i][1];
                 
                    if(isValid(rowdash,coldash,image)&&image[rowdash][coldash]==orgcolor&&image[rowdash][coldash]!=color){
                         //  System.out.println(level+"-> "+rowdash+" "+coldash+" ");
                        image[rowdash][coldash] = color;
                        q.add(new Tuple(rowdash,coldash));
                    }
                }
            }
          
        }
          return image;
    }
    
    public boolean isValid(int rowdash , int coldash ,int[][] image){
        return (rowdash>=0&&rowdash<image.length&&coldash>=0&&coldash<image[0].length);
    }
    
    static class Tuple{
        int row;
        int col;
        Tuple( int row ,int col){
            this.col = col;
            this.row= row;  
        }
    }
}