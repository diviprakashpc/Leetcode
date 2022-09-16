class Solution {
    public List<Integer> diffWaysToCompute(String expression) {
        if(expression.length()==0) return new ArrayList<>();
        if(expression.length()==1) {
            List<Integer> temp = new ArrayList<>();
            temp.add(expression.charAt(0)-'0');
            return temp;
        }
        boolean flag = false;
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < expression.length() ; i++){
            char ch =expression.charAt(i);
            if(ch=='*'||ch=='-'||ch=='+'){
                flag = true;
                List<Integer> left = diffWaysToCompute(expression.substring(0,i));
                List<Integer> right = diffWaysToCompute(expression.substring(i+1));
                for(Integer x : left){
                    for(Integer y : right){
                        ans.add(evaluate(x,y,ch));
                    }
                }
            }
        }
        if(!flag) ans.add(Integer.parseInt(expression));
        return ans;
    }
    
    public int evaluate(int x , int y , Character op){
        if(op=='*'){
            return x*y;
        }
        else if(op=='+'){
            return x+y;
        }
        else{
            return x-y;
        }
    }
}