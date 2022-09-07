class Solution {
    public List<String> removeInvalidParentheses(String s) {
       List<String> ans = new ArrayList<>();
       Set<String> set = new HashSet<>(); 
        helper(s,minRemoveToMakeValid(s),ans,set);
        return ans;
    }
    
    public void helper(String s, int minRemovals, List<String> ans,Set<String> set){
        if(minRemovals==0){
            if(minRemoveToMakeValid(s)==0){
                if(!ans.contains(s)){
                    ans.add(s);
                }
            }
            return;
        }
        if(set.contains(s)) return;
        else set.add(s);
        for(int  i = 0 ; i < s.length() ; i++){
            String left = s.substring(0,i);
            String right = s.substring(i+1);
            helper(left+right,minRemovals-1,ans,set);
        }
    }
     public int minRemoveToMakeValid(String s) {
        Stack<Integer> st = new Stack<>();
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
        
        return st.size()-1;
    }
}