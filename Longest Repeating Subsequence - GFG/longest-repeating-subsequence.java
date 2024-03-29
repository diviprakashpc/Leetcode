//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        // code here
        int m = str.length();
       int n = str.length();
       int[][] dp = new int[m+1][n+1];
       for(int j = 0 ; j <=n ; j++) dp[0][j] = 0;
       for(int i = 0 ; i<=m ; i++) dp[i][0] = 0;
       for(int i = 1 ; i <=m ; i++){
        for(int j = 1 ; j<=n ; j++){
            if(i!=j&&str.charAt(i-1)==str.charAt(j-1)){
                dp[i][j] = 1 + dp[i-1][j-1];
            }else{
                dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
            }
        }
       }
       return dp[m][n];
    }
}