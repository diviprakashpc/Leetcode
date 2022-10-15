//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class GFG {
	public static void main (String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		while(testcases-- > 0){
		    
		    String line1 = br.readLine();
		    String []element = line1.trim().split(" ");
		    int n = Integer.parseInt(element[0]);
		    int l = Integer.parseInt(element[1]);
		    int r = Integer.parseInt(element[2]);
		    
		    int arr[] = new int[n];
		    
		    
		    String line = br.readLine();
		    String[] elements = line.trim().split(" ");
		    
		    for(int index = 0;index < n; index++){
		        arr[index] = Integer.parseInt(elements[index]);
		    }
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.countSubarrays(arr, n, l, r));
		        
		}
		
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution{
    
    static long countSubarrays(int arr[], int n, int L, int R)  
    { 
        // Complete the function
        int i = 0;
        int j = 0;
        long pc = 0;
        long cnt = 0;
        while(j<arr.length){
            if(arr[j]>=L&&arr[j]<=R){
                pc = j - i + 1;
                cnt+=pc;
            }
            else if(arr[j]<L){
                cnt+=pc;
            }else if(arr[j]>R){
                i = j+1;
                pc = 0;
            }
            j++;
        }
        return cnt;
    } 
}

