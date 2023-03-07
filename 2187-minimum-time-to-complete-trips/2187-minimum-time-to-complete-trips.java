class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long l = 0;
        long maxi = time[0];
        for(int i = 0 ; i < time.length ; i++){
            maxi = Math.max(maxi,time[i])*1L;
        }
        long h = maxi * totalTrips;
        long ans = Long.MAX_VALUE;
        while(l<=h){
            long m = l + (h-l)/2;
            if(isPossible(time,m,totalTrips)){
                 h = m - 1;
                 ans = Math.min(ans,m);
            }else {
                l = m + 1;
            }
        }
        return ans;
    }
    
    public boolean isPossible(int[] time , long m,int totalTrips){
        long ans = 0;
        for(int i = 0  ; i < time.length ; i++){
            long t = time[i] * 1L;
            long trips = m/t;
            ans+=trips;
        }
        
        if(ans<totalTrips) return false;
        return true;
    }
}


