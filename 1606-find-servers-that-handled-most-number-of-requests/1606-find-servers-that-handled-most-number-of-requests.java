class Solution {
    class Pair{
        int sid;
        int et;
        Pair(int sid , int et){
            this.sid = sid;
            this.et = et;
        }
    }
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.et - b.et);
        TreeSet<Integer> idle = new TreeSet<>();
        int[] count = new int[k];
        count[0]++;
        pq.add(new Pair(0,arrival[0]+load[0]));
        int i = 1;
        for(int ii = 1 ; ii < k ; ii++) idle.add(ii);
        while(!pq.isEmpty()&&i<arrival.length){
            int ct = arrival[i];
            while(!pq.isEmpty()&&ct>=pq.peek().et){
                idle.add(pq.peek().sid);
                pq.remove();
            }
            if(idle.size()==0){
                i++;
                continue;
            }
            int to_assign = -1;
            Integer lb = idle.ceiling(i%k);
           
            if(lb==null){
                to_assign = idle.first();
            }else {
                to_assign = lb;
            }
         //    System.out.println(to_assign);
            pq.add(new Pair(to_assign,ct+load[i]));
            idle.remove(to_assign);
         //   System.out.println("size of idle "+idle.size());
            count[to_assign]++;
            i++;
        }
        //System.out.println(Arrays.toString(count));
        List<Integer> res = new ArrayList<>();
        int maxi = Integer.MIN_VALUE;
        for(int ii : count) maxi = Math.max(maxi,ii);
        for(int ii = 0 ; ii  < k ; ii++){
            if(count[ii]==maxi) res.add(ii);
        }
        return res;
        
    }
}


//Idle servers
//Current busy servers
// Pq->Active servers with et and sid.
// Ts->Idle servers with their sid.