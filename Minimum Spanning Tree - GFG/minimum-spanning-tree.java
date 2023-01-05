//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class DriverClass
{
    public static void main(String args[]) throws IOException {

        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String str[] = read.readLine().trim().split(" ");
            int V = Integer.parseInt(str[0]);
            int E = Integer.parseInt(str[1]);
    
            ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<ArrayList<ArrayList<Integer>>>();
            for(int i=0;i<V;i++)
            {
                adj.add(new ArrayList<ArrayList<Integer>>());
            }
            
            int i=0;
            while (i++<E) {
                String S[] = read.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                int w = Integer.parseInt(S[2]);
                ArrayList<Integer> t1 = new ArrayList<Integer>();
                ArrayList<Integer> t2 = new ArrayList<Integer>();
                t1.add(v);
                t1.add(w);
                t2.add(u);
                t2.add(w);
                adj.get(u).add(t1);
                adj.get(v).add(t2);
            }
            
            Solution ob = new Solution();
            
            System.out.println(ob.spanningTree(V, adj));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution
{
    static class Edge implements Comparable<Edge>{
        int u;
        int v;
        int wt;
        Edge(int u , int v , int wt){
            this.u = u;
            this.v = v;
            this.wt = wt;
        }
        public int compareTo(Edge e){
            return this.wt - e.wt;
        }
    }
    
    //Function to find sum of weights of edges of the Minimum Spanning Tree.
    static int spanningTree(int n, ArrayList<ArrayList<ArrayList<Integer>>> graph) 
    {
        // Add your code here
        boolean[] visited;
        List<Edge> mst;
        int sum = 0;
        mst = new ArrayList<>();
        visited = new boolean[n];
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.add(new Edge(-1,0,0));
        while(!pq.isEmpty()){
            
            Edge e = pq.remove();
            int u = e.u;
            int v = e.v;
            int wt = e.wt;
            if(visited[v]) continue;
            sum+=wt;
            if(u!=-1){
                mst.add(e);
            }
            
            visited[v] = true;
            for(ArrayList<Integer> nbr : graph.get(v)){
                if(!visited[nbr.get(0)]){
                    pq.add(new Edge(v,nbr.get(0),nbr.get(1)));
                }
            }
        }
        return sum;
    }
}
