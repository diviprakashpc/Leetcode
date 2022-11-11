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

public class Solution {
	
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
	        Pair(int dist , int nodeValue){
	            this.dist = dist;
	            this.nodeValue = nodeValue;
	            
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
	       
	        int[] dist = new int[n+1];
	        int[] parent = new int[n+1];
	        Arrays.fill(dist,Integer.MAX_VALUE);
	        for(int i = 1 ; i<=n ; i++) parent[i] = i;
	        dist[0] = -1;
	        dist[1] = 0;
	        PriorityQueue<Pair> pq = new PriorityQueue<>();
	        pq.add(new Pair(0,1));
	        while(!pq.isEmpty()){
	            Pair p = pq.remove();
	            int distance = p.dist;
	            int nodeValue = p.nodeValue;
	           
	            for(Node nbr : graph.get(nodeValue)){
	                if(dist[nbr.value]>distance + nbr.wt){
	                    dist[nbr.value] = distance +nbr.wt;
	                    parent[nbr.value] = nodeValue;
	                    pq.add(new Pair(dist[nbr.value],nbr.value));
	                }
	            }
	        }
	        
	        
	        int nodeValue = n;
	        List<Integer> ans = new ArrayList<>();
	        if(dist[nodeValue]==Integer.MAX_VALUE){
	            ans.add(-1);
	            return ans;
	        }
	        while(parent[nodeValue]!=nodeValue) {
	        	ans.add(0, nodeValue);
	        	nodeValue = parent[nodeValue];
	        }
	        ans.add(0,1);
	        return ans;
	    }

}
