class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        int i = 0;
        int j = 0;
        int[] res = new int[arr.length-(k-1)];
        List<Integer> temp = new ArrayList<>();
        int kk = 0;
        int currmax = Integer.MIN_VALUE;
        while(j<arr.length){
             if(temp.size()==0){
                 temp.add(arr[j]);
             }else{
                 while(temp.size()!=0&&temp.get(temp.size()-1)<arr[j]){
                     temp.remove(temp.size()-1);
                 }
                 temp.add(arr[j]);
             }
            if(j-i+1<k) j++;
            else if(j-i+1==k){
               res[kk++] = temp.get(0);
                if(arr[i]==temp.get(0)){
                   temp.remove(0);
                }
                i++;
                j++;
            }
        }
        
        
       return res;
    }
}