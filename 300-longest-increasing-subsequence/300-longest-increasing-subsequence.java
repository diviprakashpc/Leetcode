class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[0]);
        for(int i = 1 ; i < nums.length ; i++){
            if(nums[i]>ans.get(ans.size()-1)){
                ans.add(nums[i]);
            }
            else{
                int lb = lower_bound(ans,nums[i]);
                ans.set(lb,nums[i]);
            }
        }
        return ans.size();
    }
    
    static int lower_bound(List<Integer> array, int key) {
     
	      int lb = Collections.binarySearch(array, key);
	      
	      if(lb<0) {
	    	  return Math.abs(lb)-1;
	      }
	      else {
	    	  int y = array.get(lb);
	    	  int i = lb-1;
	    	  while(i>=0&&array.get(i)==y) {
	    		  lb--;
	    		  i--;
	    	  } 
	      }
		  return lb;
		}
}