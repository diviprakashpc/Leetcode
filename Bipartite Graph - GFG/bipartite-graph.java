// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            int E = Integer.parseInt(S[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for(int i = 0; i < V; i++){
                adj.add(new ArrayList<Integer>());
            }
            for(int i = 0; i < E; i++){
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(V, adj);
            if(ans)
                System.out.println("1");
            else System.out.println("0");
       }
    }
}// } Driver Code Ends


class Solution

{
    public boolean itsBipartite(int n , int src, ArrayList<ArrayList<Integer>> adj,int[] visited){
               // Code here
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        while(!q.isEmpty()){
           int size = q.size();
            while(size-->0){
                Pair front = q.remove();
                if(visited[front.value]!=-1&&visited[front.value]!=front.level) return false;
                  visited[front.value] = front.level;
                for(Integer i : adj.get(front.value)){
                    if(visited[i]==-1){
                        q.add(new Pair(i,front.level+1));
                    }
                }
                
            }
        }
        
        return true;
        
    }
    public boolean isBipartite(int n, ArrayList<ArrayList<Integer>>adj)
    {
        int[] visited = new int[n];
        Arrays.fill(visited,-1);
        
        
        for(int i = 0 ; i < n ; i++){
            if(visited[i]==-1){
                boolean b = itsBipartite(n,i,adj,visited);
                if(!b) return false;
            }
        }
        return true;
        
    }
}

class Pair {
    int value;
    int level;
    Pair(int value, int level){
        this.value = value;
        this.level = level;
    }
}