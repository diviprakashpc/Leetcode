//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    List<Integer> ans;
    int search(String pat, String txt) {
        // code here
        ans = new ArrayList<>();
        checkInclusion(pat,txt);
        return ans.size();
    }
    
    //checkInclusion is method of leetcode permutation in string ques.
     public void checkInclusion(String s1, String s2) {
        int[] f1  = new int[26];
        int[] f2 = new int[26];
        for(int i = 0 ; i < s1.length() ; i++) f1[s1.charAt(i)-'a']++;
        int m  = s1.length();
        int n = s2.length();
        int i  = 0 ;
        int j = 0;
        
        while(j < s2.length()){
            if(j-i+1<m){
                f2[s2.charAt(j)-'a']++;
            }else{
                 f2[s2.charAt(j)-'a']++;
                 if(matching(f1,f2)) ans.add(i);
                 f2[s2.charAt(i)-'a']--;
                 if( f2[s2.charAt(i)-'a']<=0)  f2[s2.charAt(i)-'a'] = 0;
                i++;
            }
            j++;
        }
        
        return;
    }
    
    public boolean matching(int[] f1 , int[] f2){
        for(int i = 0 ; i < 26  ; i++){
            if(f1[i]!=f2[i]) return false;
        }
        return true;
    }
}