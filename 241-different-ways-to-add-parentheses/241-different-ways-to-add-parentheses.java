class Solution {
    public List<Integer> diffWaysToCompute(String str) {
        List<Integer> ans = new ArrayList<>();
        for(int i = 0 ; i < str.length() ; i++){
            char ch = str.charAt(i);
            if(ch=='*'||ch=='-'||ch=='+'){
                String left = str.substring(0,i);
                String right = str.substring(i+1);
                List<Integer> ll = diffWaysToCompute(left);
                List<Integer> rl = diffWaysToCompute(right);
                for(Integer x : ll){
                    for(Integer y : rl){
                        if(ch=='+'){
                            ans.add(x+y);
                        }else if(ch=='-'){
                            ans.add(x-y);
                        }
                        else if(ch=='*'){
                            ans.add(x*y);
                        }
                        
                    }
                }
                
            }
        }
        if(ans.size()==0){
            ans.add(Integer.parseInt(str));
        }
        return ans;
    }
}