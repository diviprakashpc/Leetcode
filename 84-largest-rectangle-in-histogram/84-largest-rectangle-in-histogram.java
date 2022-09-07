class Solution {
    public int largestRectangleArea(int[] heights) {
        int[] nse = nextSmaller(heights);
        int[] pse = prevSmaller(heights);
        // for(int i = 0 ; i < nse.length ; i++){
        //     System.out.print(nse[i]+" ");
        // }
        // System.out.println();
        // for(int i = 0 ; i < pse.length ; i++){
        //     System.out.print(pse[i]+" ");
        // }
        // System.out.println();
        int maxArea = 0;
        for(int i = 0 ; i < heights.length ; i++){
            int li = (pse[i]==-1)?-1:pse[i];
            int ri = nse[i]==-1?heights.length+1:nse[i];
            if(li==-1&&ri==heights.length+1) maxArea = Math.max(maxArea,heights.length*heights[i]);
            else if(li==-1||ri==heights.length+1){
               if(li==-1){
                   maxArea = Math.max(maxArea,ri*heights[i]);
               }else{
                   maxArea = Math.max(maxArea,(heights.length-li-1)*heights[i]);
               }
            }
            else maxArea = Math.max(maxArea,(ri-li-1)*heights[i]);
         //   System.out.print(maxArea+" ");
        }
        return maxArea;
    }
    
    public int[] prevSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = 0;  i < arr.length ; i++){
            while(st.size()>0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
                st.push(i);
            }else{
                res[i] = st.peek();
                st.push(i);
            }
        }
        return res;
    }
    
    public int[] nextSmaller(int[] arr){
        Stack<Integer> st = new Stack<>();
        int[] res = new int[arr.length];
        for(int i = arr.length-1;  i >=0 ; i--){
            while(st.size()>0&&arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(st.isEmpty()){
                res[i] = -1;
                st.push(i);
            }else{
                res[i] = st.peek();
                st.push(i);
            }
        }
        return res;
    }
}