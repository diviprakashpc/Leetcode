class Solution {
  
  static class Job{
    int s;
    int e;
    int p;
    Job(int s , int e , int p){
      this.s = s; 
      this.e = e;
      this.p = p;
    }
  }
   
  public int jobScheduling(int[] s, int[] e, int[] profit) {
      Job[] jobs = new Job[s.length];
      for(int i = 0 ; i < s.length ; i++){
        jobs[i] = new Job(s[i],e[i],profit[i]);
      }
      Arrays.sort(jobs,(a,b)->a.e-b.e);
      int[] dp = new int[jobs.length];
      dp[0] = jobs[0].p;
      for(int i = 1;i<jobs.length ;i++){
        int next = findNext(jobs,i);
        dp[i] = Math.max(jobs[i].p+(next==-1?0:dp[next]),dp[i-1]);
      }
      return dp[jobs.length-1];
    }
  
    private int findNext(Job[] jobs, int index) {
        int start = 0, end = index - 1;
        int lb = -1;
        while(start<=end){
          int mid = (start+end)/2;
          if(jobs[mid].e>jobs[index].s){
             end = mid-1;
          }else{
            lb = Math.max(lb,mid);
            start = mid + 1;
          }
        }
    return lb;
    }
  
        
  
}