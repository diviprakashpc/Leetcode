class Solution {
    public int canCompleteCircuit(int[] p, int[] d) {
      int n = p.length;
	  int start = 0;
	  int cp = 0;
	  int prevp = 0;
	  for(int i = 0 ; i < n ; i++){
	      cp+=p[i]-d[i];
	      if(cp<0){
	          start = i+1;
	          prevp+=cp;
	          cp = 0;
	      }
	  }
	  return (cp+prevp>=0) ? start : -1;
    }
}