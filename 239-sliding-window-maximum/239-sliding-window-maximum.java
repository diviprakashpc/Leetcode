class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0;
        int j = 0;
        List<Integer> temp = new ArrayList<>();
        int[] res = new int[nums.length-(k-1)];
        int itr = 0;
        while(j<nums.length){
            if(temp.size()==0) temp.add(nums[j]);
            else{
                while(temp.size()!=0&&temp.get(temp.size()-1)<nums[j]){
                    temp.remove(temp.size()-1);
                }
                temp.add(nums[j]);
            }
             if(j-i+1<k){
                 j++;
             }else{
                 res[itr++] = temp.get(0);
                 if(nums[i]==temp.get(0)){
                     temp.remove(0);
                 }
                 i++;
                 j++;
             }
        }
        return res;
    }
}