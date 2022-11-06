class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
         PriorityQueue<Pair> pq1 = new PriorityQueue<>();
         PriorityQueue<Pair> pq2 = new PriorityQueue<>();
         for(int i = 0 ; i < candidates ; i++) {
           pq1.add(new Pair(costs[i],i));
           costs[i]=Integer.MAX_VALUE;
         }
         for(int i = costs.length-candidates ; i<costs.length ; i++) {
           pq2.add(new Pair(costs[i],i));
           costs[i] = Integer.MAX_VALUE;
         } 
       long ans = 0;
       long count = 0;
       int i = candidates;
       int j = costs.length-candidates-1;
       while(count!=k){
          Pair p1 = pq1.size()!=0?pq1.peek():new Pair(Integer.MAX_VALUE,-1);
          Pair p2 = pq2.size()!=0?pq2.peek():new Pair(Integer.MAX_VALUE,-1);
          if(p1.val<=p2.val){
            pq1.remove();
            ans+=p1.val;
            count++;
            if(i<=j){
            pq1.add(new Pair(costs[i],i));
            i++;
            }
          }else if(p2.val<p1.val){
            pq2.remove();
            ans+=p2.val;
            count++;
            if(i<=j){
            pq2.add(new Pair(costs[j],j));
            j--;
            }
          }
       }
      return ans;
    }
  
      static class Pair implements Comparable<Pair>{
      int val;
      int idx;
      Pair(int val,int idx){
        this.val = val;
        this.idx = idx;
      }
      public int compareTo(Pair p){
        if(this.val<p.val) return -1;
        else if(this.val>p.val) return 1;
        else {
            return this.idx-p.idx;
        }
      }
    }
  
    }
