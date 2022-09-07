class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
       int[] res = new int[nums.length-k+1];
        int[] nge = nextGreaterElement(nums);
        int itr = 0;
       for(int i = 0 ; i <= nums.length-k ; i++){
           int j = i;
           while(nge[j]<i+k){
               j = nge[j];
           }
           res[itr++] = nums[j];
       }
        return res;
    }
    
    public int[]  nextGreaterElement(int[] nums){
        int[] nge = new int[nums.length];
        Stack<Integer> st = new Stack<>();
        // pop ans push
        for(int i = nums.length - 1 ; i>=0 ; i--){
            while(st.size()>0&&nums[i]>=nums[st.peek()]){
                st.pop();
            }
            if(st.isEmpty()){
                nge[i] = nums.length;
            }else{
                nge[i] = st.peek();
            }
            st.push(i);
        }
        return nge;
    }
}