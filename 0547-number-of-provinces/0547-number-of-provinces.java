class Solution {
    public int findCircleNum(int[][] c) {
       DisjointSet ds = new DisjointSet(c.length);
       ds.makeSet(c.length);
       for(int i =0 ; i < c.length ; i++){
         for(int j = 0 ; j < c[0].length ; j++){
              if(c[i][j]==1){
                 ds.union_by_size(i,j);
              }
         }
       }
      
      // for(int i = 0;  i < ds.parent.length ; i++){
      //   System.out.print(ds.parent[i]+" ");
      // }
      int n_o_p = 0;
     Set<Integer> set = new HashSet<>();
       for(int i = 0;  i < c.length ; i++){
          int leader = ds.find(i);
          set.add(leader);
       }
      return set.size();
      
    }
    
   static class DisjointSet{
      int[] parent;
      int[] size;
     DisjointSet(int n){
       parent = new int[n+1];
       size = new int[n+1];
     }
     
      void makeSet(int n){
       for(int i = 0 ; i<=n ; i++){
         parent[i] = i;
         size[i] = 1;
       }
     }
     
      int find(int x){
        if(x==parent[x]){
           return x;
        }
        
        int found = find(parent[x]);
        parent[x] = found;
        return found;
     }
     
      void union_by_size(int x, int y){
       int lx = find(x);
       int ly = find(y);
       if(lx==ly) return;
       if(size[lx]>size[ly]){
         parent[ly] = lx;
         size[ly]+=size[lx];
       }else{
         parent[lx] = ly;
         size[lx]+=size[ly];
       }
     }
   }
}