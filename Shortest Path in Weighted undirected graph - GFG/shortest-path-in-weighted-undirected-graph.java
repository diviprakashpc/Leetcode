//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    static String shortestPath;
    static class Node{
        int value;
        int wt;
        Node(int val , int w){
            value = val;
            wt = w;
        }
    }
    
    static class Pair implements Comparable<Pair>{
        int dist;
        int nodeValue;
        String sp;
        Pair(int dist , int nodeValue, String sp){
            this.dist = dist;
            this.nodeValue = nodeValue;
            this.sp = sp;
        }
        
        public int compareTo(Pair p) {return this.dist - p.dist;}
    }
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<List<Node>> graph = new ArrayList<>();
        for(int i =0  ; i <=n ; i++) graph.add(new ArrayList<>());
        for(int[] row : edges){
            int u = row[0];
            int v = row[1];
            int wt = row[2];
            graph.get(u).add(new Node(v,wt));
            graph.get(v).add(new Node(u,wt));
        }
        shortestPath ="";
        int[] dist = new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = -1;
        dist[1] = 0;
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        pq.add(new Pair(0,1,"1$"));
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int distance = p.dist;
            int nodeValue = p.nodeValue;
            String sp = p.sp;
            for(Node nbr : graph.get(nodeValue)){
                if(dist[nbr.value]>distance + nbr.wt){
                    dist[nbr.value] = distance +nbr.wt;
                    if(nbr.value==n){
                        shortestPath = sp + Integer.toString(nbr.value)+'$';
                        
                    }
                    pq.add(new Pair(dist[nbr.value],nbr.value,sp+nbr.value+'$'));
                }
            }
        }
        
        List<Integer> ans = new ArrayList<>();
      //  System.out.println(shortestPath);
        String[] arr = shortestPath.split("\\$");
        for(int i = 0 ; i < arr.length ; i++) if(arr[i].length()!=0) ans.add(Integer.parseInt(arr[i]));
        if(ans.size()==0) ans.add(-1);
        return ans;
    }
}