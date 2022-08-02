class Solution {
    public int longestValidParentheses(String s) {
        Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        index.push(-1);
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(ch);
                index.push(i);
            }else{
                if(stack.isEmpty()){
                    index.push(i);
                }else{
                    stack.pop();
                    index.pop();
                    max = Math.max(max,i-index.peek());
                }
            }
        }
        return max;
    }
}