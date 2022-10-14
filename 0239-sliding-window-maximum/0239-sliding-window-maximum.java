class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int size = arr.length - k +1 ;
        int[] ans = new int[size];
        int idx = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        int i = 0;
        int j = 0;
        while(j<arr.length){
            while(dq.size()>0&&dq.getLast()<arr[j]) dq.removeLast();
            dq.addLast(arr[j]);
             if(j-i+1==k){
                ans[idx++] = dq.getFirst();
                if(arr[i]==dq.getFirst()){
                    dq.removeFirst();
                }
                i++;
            }
            j++;
        }
      
        return ans;
    }
}