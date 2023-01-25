class Solution {
    
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);
        bfs(edges,node1,dist1);
        bfs(edges,node2,dist2);
        
        int idx = -1;
        int currmin = Integer.MAX_VALUE;
        for(int i = 0 ; i < n ; i++) {
            int v1 = dist1[i];
            int v2 = dist2[i];
            int maxi = Math.max(v1,v2);
            if(maxi<currmin){
                currmin = maxi;
                idx = i;
            }
        }
        return idx;
    }
    
    public void bfs(int[] edges , int src , int[] dist){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        dist[src] = 0;
        while(!q.isEmpty()){
            Integer pval = q.remove();
            int nbr = edges[pval];
            if(nbr!=-1&&dist[nbr]>dist[pval]+1){
                dist[nbr] = dist[pval] + 1;
                q.add(nbr);
            }
        } 
    }
}