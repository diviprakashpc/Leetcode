class Solution {
    public int shipWithinDays(int[] w, int days) {
        int sum = 0;
        int mx = 0;
        for(int i : w){
            sum+=i;
            mx = Math.max(mx,i);
        }
        int l = mx;
        int h = sum;
        if(days==1){
          return sum;
        }
        int min_cap = sum;
        while(l<=h){
            int cap = l + (h-l)/2;
            if(isPossible(w,cap,days)){
                min_cap = Math.min(min_cap,cap);
                h = cap - 1;
            }
            else l = cap + 1;
        }
        return min_cap;
    }

    public boolean isPossible(int[] arr, int min , int k){
        int cs = 0;
        int grps = 0;
        for(int i = 0 ; i  < arr.length ;){
            if(cs+arr[i]>min){
                cs = 0;
                grps++;
            }else{
                cs+=arr[i];
                i++;
            }
        }
        grps++;
       
        if(grps>k) return false;
        else return true;
    }
}