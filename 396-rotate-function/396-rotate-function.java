class Solution {
    public int maxRotateFunction(int[] arr) {
        int sum = Arrays.stream(arr).sum();
        int n = arr.length;
        int prev = 0;
        for(int i = 0 ; i < n ; i++){
            prev+=(i*arr[i]);
        }
         int ans = prev;
        for(int i = n-2 ; i>=0 ; i--){
            int temp = sum;
            int restsum = temp-arr[i+1];
            int diff = (1-n)*(arr[i+1]) + restsum;
            prev = diff + prev;
            ans = Math.max(prev,ans);
        }
        return ans==Integer.MIN_VALUE?0:ans;
    }
}