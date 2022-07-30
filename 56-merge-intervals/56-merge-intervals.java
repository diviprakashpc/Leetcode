class Solution {
    public int[][] merge(int[][] arr) {
        Pair[] pair = new Pair[arr.length];
        for(int i = 0 ; i < arr.length ; i++){
          pair[i]=new Pair(arr[i][0],arr[i][1]);
        }
        Arrays.sort(pair,(a,b)->a.st-b.st);
        Stack<Pair> stack = new Stack<>();
        stack.push(pair[0]);
        for(int i = 1 ; i < pair.length ; i++){
            int st  = pair[i].st;
            int et = pair[i].et;
            Pair p = stack.peek();
            if(st<=p.et){
                stack.pop();
                stack.push(new Pair(p.st,Math.max(p.et,et)));
            }else{
                stack.push(new Pair(st,et));
            }
        }
        
        Stack<Pair> rStack = new Stack<>();
        
        while(stack.size()>0){
            rStack.push(stack.pop());
        }
        
        int[][] ans = new int[rStack.size()][2];
        int k = 0;
        while(rStack.size()>0){
            ans[k][0] = rStack.peek().st;
            ans[k][1]= rStack.peek().et;
            rStack.pop();
            k++;
        }
        
        return ans;
        
        
    }
    
    class Pair{
        int st;
        int et;
        Pair(int st, int et){
            this.st = st;
            this.et = et;
        }
    }
}