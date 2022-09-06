class Solution {
    //O(m+n) because every element is getting push and pop only one time.
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i : nums1) set.add(i);
        Stack<Integer> stack = new Stack<>();
        
        for(int i = nums2.length-1 ; i>=0 ; i--){
           
                while(stack.size()>0&&stack.peek()<=nums2[i]){
                    stack.pop();
                }
                if(stack.size()==0){
                    if(set.contains(nums2[i])) map.put(nums2[i],-1);
                }else{
                    if(set.contains(nums2[i])) map.put(nums2[i],stack.peek());
                }
                 stack.push(nums2[i]);
        }
        
        int[] res = new int[nums1.length];
        for(int i = 0 ; i < nums1.length ; i++){
            res[i] = map.get(nums1[i]); 
        }
        return res;
    }
}