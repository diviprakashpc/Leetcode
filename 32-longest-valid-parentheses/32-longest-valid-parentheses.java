class Solution {
    public int longestValidParentheses(String s) {
      Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int ans = 0;
        int curr = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
             if(ch=='('){
                stack.push(i);
            }
            else{
                int idx = stack.peek();
                if(idx!=-1&&s.charAt(idx)=='('){
                    stack.pop();
                    ans = Math.max(ans,i-stack.peek());
                }
                else {
                    stack.push(i);
                }
            }
        }
        return ans;
    }
}