class Solution {
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int mxR = 0;
        int mxC = 0;
      for(int[] row : stones){
        mxR = Math.max(mxR,row[0]);
        mxC = Math.max(mxC,row[1]);
      }
      
      DisjointSet ds = new DisjointSet(mxR+mxC+1);
      ds.makeSet(mxR+mxC+1);
      HashMap<Integer,Integer> map = new HashMap<>();
      for(int[] row : stones){
        int nodeR = row[0];
        int nodeC = row[1] + mxR + 1;
        ds.union(nodeR,nodeC);
        map.put(nodeR,1);
        map.put(nodeC,1);
      }
      
      int ans = 0;
      for(Integer i : map.keySet()){
        if(ds.find(i)==i){
          ans++;
        }
      }
      return n - ans;
    }
  
  public static class DisjointSet {
	int[] parent;
	int[] rank;

	DisjointSet(int n) {
		parent = new int[n+1];
		rank = new int[n+1];
	}

	public void makeSet(int n) {
		for (int i = 0; i <= n; i++) {
			parent[i] = i;
			rank[i] = 0;
		}
	}

	public void union(int x, int y) {
		int lx = find(x);
		int ly = find(y);
		if (lx != ly) {
			if (rank[lx] > rank[ly]) {
				parent[ly] = lx;
			} else if (rank[lx] < rank[ly]) {
				parent[lx] = ly;
			} else {
				parent[lx] = ly;
				rank[ly]++;
			}
		}
	}

	public int find(int x) {
		if (parent[x] == x) {
			return x;
		}
		int temp = find(parent[x]);
		parent[x] = temp;
		return temp;
	}
  }
}