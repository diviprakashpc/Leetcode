class MinStack {
      Stack<Pair> stack;
      long min;
    public MinStack() {
        stack = new Stack<>();
        min = Long.MAX_VALUE ;
    }
    
    public void push(int val) {
        if(min>=val) min = val;
        stack.push(new Pair(val,min));
        return;
    }
    
    public void pop() {
         Pair p = stack.pop();
          if(stack.isEmpty()) min = Long.MAX_VALUE;
        else if(p.min==this.min){
            min = stack.peek().min;
        }
      
        return;
    }
    
    public int top() {
        return stack.peek().val;
    }
    
    public int getMin() {
        return (int)stack.peek().min;
    }
}

class Pair{
    int val;
    long min;
    Pair(int val ,long min){
        this.val = val;
        this.min = min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */