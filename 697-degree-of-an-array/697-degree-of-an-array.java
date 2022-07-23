class Solution {
    public int findShortestSubArray(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        int[] freq = new int[50001];
        int degree = 0;
        for(int i : nums){
           freq[i]++;
            if(freq[i]>degree){
                degree = freq[i];
            }
        }
    
        for(int i = 0 ; i < freq.length ; i++){
            if(freq[i]==degree) set.add(i);
        }
        
      
        
        int minlen  = Integer.MAX_VALUE;
        for(Integer element : set){
        int l = 0;
        int h = 0;
            for(int i = 0 ; i < nums.length ; i++){
            if(nums[i]==element){
                l = i;
                break;
            }
        }
        
        for(int i = nums.length-1 ; i>=0 ; i--){
            if(nums[i]==element){
                h = i;
                break;
            }
        }
           
            minlen = Math.min(minlen,h-l+1);
             
        }
        
        
        return minlen;
        
    }
}