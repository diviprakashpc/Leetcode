class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefixProd = new int[n];
        int[] suffixProd = new int[n];
        prefixProd[0] = nums[0];
        suffixProd[n-1] = nums[n-1];
        for(int i = 1 ; i < nums.length ; i++){
            prefixProd[i] = prefixProd[i-1] * nums[i]; 
            suffixProd[n-i-1] = suffixProd[n-i] * nums[n-i-1];
        }
        System.out.println(Arrays.toString(suffixProd));
        int[] ans = new int[n];
        for(int i = 0 ; i < n ; i++){
            if(i==0){
               ans[i] = suffixProd[i+1]; 
            }else if(i==n-1){
                ans[i] = prefixProd[i-1];
            }else{
                ans[i] = prefixProd[i-1] * suffixProd[i+1];
            }
        }
        return ans;
    }
}