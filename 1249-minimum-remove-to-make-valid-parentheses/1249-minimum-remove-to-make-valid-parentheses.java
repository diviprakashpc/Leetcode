class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder sb = new StringBuilder(s);
        st.push(-1);
        for(int i = 0 ; i < s.length() ; i++){
            char ch = s.charAt(i);
            if(ch>='a'&&ch<='z') continue;
            if(ch=='('){
                st.push(i);
            }
            else{
                if(st.peek()!=-1&&s.charAt(st.peek())=='('){
                    st.pop();
                }else{
                  st.push(i);
                }
            }
        }
        
        while(st.peek()!=-1&&!st.isEmpty()){
           sb.delete(st.peek(),st.peek()+1);
            st.pop();
        }
        return sb.toString();
    }
}