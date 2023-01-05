//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    int a[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    {
		        a[i]=sc.nextInt();
		    }
		    int m=sc.nextInt();
		    Solution ob = new Solution();
		    System.out.println(ob.findPages(a,n,m));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution 
{
    //Function to find minimum number of pages.
    public static int findPages(int[]arr,int n,int m)
    {
        //Your code here
        int l = 0;
        for(int i : arr) l = Math.max(l,i);
        int h = Arrays.stream(arr).sum();
        int ans = Integer.MAX_VALUE;
        if(n==m) return l;
        if(m>n) return -1;
        while(l<=h){
            int min = l + (h-l)/2;
            int k  = isPossible(arr,min,m);
          //  System.out.println(min+" and "+k);
            if(k==0){
                h = min - 1;
                ans = Math.min(ans,min);
            }else if(k==1){
                l = min + 1;
            }
        }
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    
    public static int isPossible(int[] arr , int min , int m){
        int cs = 0;
        int grps = 0;
        for(int i = 0 ; i  < arr.length ;){
            if(cs+arr[i]>min){
                cs = 0;
                grps++;
            }else{
                cs+=arr[i];
                i++;
            }
        }
        grps++;
       
         if(grps>m) return 1;
        else return 0;
    }
};