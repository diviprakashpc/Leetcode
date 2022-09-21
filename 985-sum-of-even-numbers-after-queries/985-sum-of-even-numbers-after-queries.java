class Solution {
    public int[] sumEvenAfterQueries(int[] nums, int[][] q) {
        int sum = 0;
        for(int  i : nums) {
            if(i%2==0) sum+=i;
        }
        int[] ans = new int[q.length];
        int k = 0;
        int i = 0;
        int size = q.length;
        while(i<size){
            int offset = q[i][0];
            int pos = q[i][1];
            int oval =nums[pos];
            if(oval%2==0){
                int nval = oval + offset;
                if(nval%2==0){
                    sum = sum - oval + nval;
                    ans[k++] = sum;
                     nums[pos] = nval;
                }else{
                    sum = sum - oval;
                      ans[k++] = sum;
                     nums[pos] = nval;
                }
            }else{
                 int nval = oval + offset;
                if(nval%2==0){
                    sum = sum + nval;
                    ans[k++] = sum;
                     nums[pos] = nval;
                }else{
                      ans[k++] = sum;
                     nums[pos] = nval;
                }
            }
           
            i++;
        }
        return ans;
        
    }
}