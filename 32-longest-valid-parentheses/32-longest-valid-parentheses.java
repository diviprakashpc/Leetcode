class Solution {
    public int longestValidParentheses(String s) {
        // Stack<Character> stack = new Stack<>();
        Stack<Integer> index = new Stack<>();
        index.push(-1);
        int max = 0;
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch=='('){
                index.push(i);
            }else{

                 if(index.peek()!=-1&&s.charAt(index.peek())=='('){
                    index.pop();
                    max = Math.max(max,i-index.peek());
                }
                else index.push(i);
            }
        }
        return max;
    }
}