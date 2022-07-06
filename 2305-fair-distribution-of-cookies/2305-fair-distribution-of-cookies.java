class Solution {
    int ans = Integer.MAX_VALUE;
    public int distributeCookies(int[] cookies, int k) {
        int count[]  = new int[k];
         helper(cookies,0,k,count);
        return ans;
    }
    
    public void helper(int[] cookies , int i , int k,int[] count){
        if(i==cookies.length){
            int max = 0;
            for(Integer c : count){
                max = Math.max(c,max);
            }
            ans = Math.min(ans,max);
            return;
        }
        
        for(int j = 0 ; j < k ; j++){
            count[j]+=cookies[i];
            helper(cookies,i+1,k,count);
            count[j]-=cookies[i];
        }
        
        return;
    }
}