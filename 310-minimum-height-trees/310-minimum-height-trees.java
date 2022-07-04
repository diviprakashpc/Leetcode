class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if(n==1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(0);
            return temp;
        }
         int[] degree= new int[n];
         ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for(int i =0  ; i < n ; i++) graph.add(new ArrayList<>());
        for(int i = 0 ; i < edges.length ; i++){
            int u = edges[i][0];
            int v = edges[i][1];
            degree[u]++;
            degree[v]++;
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
       Queue<Integer> q  = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            if(degree[i]==1){
                q.add(i);
            }
        }
        while(n>2){
            int size = q.size();
            n-=size;
            while(size-->0){
                int front = q.remove();
                for(Integer i : graph.get(front)){
                    degree[i]--;
                    if(degree[i]==1){
                        q.add(i);
                    }
                }
            }
        }
        
        return (List)q;
    }
}