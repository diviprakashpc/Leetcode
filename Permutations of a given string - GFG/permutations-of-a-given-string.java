//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            String S = br.readLine().trim();
            Solution obj = new Solution();
            List<String> ans = obj.find_permutation(S);
            for( int i = 0; i < ans.size(); i++)
            {
                out.print(ans.get(i)+" ");
            }
            out.println();
                        
        }
        out.close();
	}
}


// } Driver Code Ends


class Solution {
    static List<String> ans;
    static Set<Integer> set;
    static Set<String> res;
    public List<String> find_permutation(String S) {
        // Code here
        set = new HashSet<>();
        ans = new ArrayList<>();
        res = new HashSet<>();
       helper("",S,-1); 
       for(String str : res) ans.add(str);
       Collections.sort(ans);
       return ans;
    }
    
    public static void helper(String curr, String s,int idx){
        if(curr.length()==s.length()){
            res.add(curr);
            return;
        }
        for(int i = 0 ; i < s.length() ; i++){
           if(set.contains(i)) continue;
           if(i==idx) continue;
           curr = curr + s.charAt(i);
           set.add(i);
           helper(curr,s,i);
           curr = curr.substring(0,curr.length()-1);
           set.remove(i);
        }
    }
}