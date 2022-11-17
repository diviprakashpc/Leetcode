//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            long n = Long.parseLong(read.readLine());
            
            Solution ob = new Solution();
            
            ArrayList<Long> answer = ob.absDifOne(n);
            
            for(long value :  answer){
                System.out.print(value+" ");
            }
            
            if(answer.size() == 0)
            System.out.print(-1);
            
            System.out.println();

        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    ArrayList<Long> absDifOne(long n){
        ArrayList<Long> ans = new ArrayList<>();
        long curr = 0;
        for(int i = 1 ; i<=9 ; i++){
          helper(n,curr+i,i,ans);
        }
        
         Collections.sort(ans);
         return ans;
    }
    
    void helper(long n , long curr , long lastDigit , ArrayList<Long> ans){
       if(curr>n) return;
    //   if(curr.length()!=1&&Long.parseLong(curr)<=n){
          if(curr/10!=0&&curr<=n) ans.add(curr);
       
       if(lastDigit==0){
           helper(n,curr*10 + lastDigit+1,lastDigit+1,ans);
       }
       else if(lastDigit==9){
            helper(n,curr*10+(lastDigit-1),lastDigit-1,ans);
       }
       else{
       helper(n,curr*10+(lastDigit-1),lastDigit-1,ans);
       helper(n,curr*10+(lastDigit+1),lastDigit+1,ans);
       }
    }
}