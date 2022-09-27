class Solution {
    public int maximumProduct(int[] nums) {
      if(nums.length==3) return nums[0]*nums[1]*nums[2];
      List<Integer> neg = new ArrayList<>();
      List<Integer> pos = new ArrayList<>();
      for(int i : nums){
        if(i<0) neg.add(i);
        else pos.add(i);
      }
      Collections.sort(neg);
      Collections.sort(pos);
      int op1 = Integer.MIN_VALUE;
      int op2 = Integer.MIN_VALUE;
      if(neg.size()>1&&pos.size()>0){
        op1 = neg.get(0) * neg.get(1) * pos.get(pos.size()-1);
      }
      else if(neg.size()>2){
        op1 = neg.get(neg.size()-1) * neg.get(neg.size()-2) * neg.get(neg.size()-3);
      }
      if(pos.size()>2)
      op2 = pos.get(pos.size()-1) * pos.get(pos.size()-2) * pos.get(pos.size()-3);
      
      return Math.max(op1,op2);
    }
}