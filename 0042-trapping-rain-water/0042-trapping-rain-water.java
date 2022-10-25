class Solution {
    public int trap(int[] height) {
        int[] prefixMax = new int[height.length];
        int[] suffixMax = new int[height.length];
        int currMax = -1; 
        for(int i= 0 ; i < height.length ; i++){
          prefixMax[i] = Math.max(currMax,height[i]);
          currMax = Math.max(currMax,height[i]);
        }
      
       currMax = -1;
       for(int i = height.length-1;i>=0 ;i--){
         suffixMax[i] = Math.max(currMax,height[i]);
         currMax = Math.max(currMax,height[i]);
       }
      
        int waterTrapped = 0;
        for(int i = 0 ; i < height.length;i++){
           waterTrapped+=(Math.min(prefixMax[i],suffixMax[i])-height[i]);
        }
      return waterTrapped;
    }
}