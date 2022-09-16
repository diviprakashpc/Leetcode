class Solution {
    public List<String> generateParenthesis(int n) {
        if(n==0){
            List<String> temp = new ArrayList<>();
            temp.add("");
            return temp;
        }
        List<String> ans = new ArrayList<>();
        for(int i = 0 ; i <=n-1 ; i++){
            List<String> left = generateParenthesis(i);
            List<String> right = generateParenthesis(n-i-1);
            for(String l1 : left){
                for(String r1 : right){
                    ans.add('('+l1+')'+r1);
                }
            }
        }
        return ans;
    }
}