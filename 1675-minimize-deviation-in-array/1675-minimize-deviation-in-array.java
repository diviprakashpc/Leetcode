class Solution {
    public int minimumDeviation(int[] nums) {                                                                                                                          
       PriorityQueue<Integer> max = new PriorityQueue<>((a,b)->b-a);
       int mind = Integer.MAX_VALUE;
        int mini = Integer.MAX_VALUE;
       for(int i : nums){
           if(i%2==0){
               max.add(i);
               mini = Math.min(mini,i);
           }else {
               max.add(2*i);
               mini = Math.min(mini,2*i);
           }
       }
        while(true){
            int x = max.remove();
            mind = Math.min(Math.abs(x-mini),mind);
            if(x%2!=0) break;
            max.add(x/2);
            mini = Math.min(x/2,mini);  
        }
        return mind;
    }
}                