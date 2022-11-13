class Solution {
    public int findUnsortedSubarray(int[] nums) {
       Stack<Integer> st = new Stack<>();
       int left = nums.length;
       int right = 0;
       for(int i = 0 ;i < nums.length ; i++){
          while(!st.isEmpty()&&nums[st.peek()]>nums[i]) {
              left = Math.min(left,st.peek());
              st.pop();
          }
         st.push(i);
       }
    
     st.clear();
    
     for(int i = nums.length-1 ; i>=0 ;i--){
       while(!st.isEmpty()&&nums[st.peek()]<nums[i]){
          right = Math.max(right,st.peek());
          st.pop();
       }
          st.push(i);
     }
    // System.out.println(left+" "+right);
    return left<right?right-left+1:0;
      }
}