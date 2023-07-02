//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;


class Array {

	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		while(t-->0){
		  
		    //size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    //calling trappingWater() function
		    System.out.println(obj.trappingWater(arr, n));
		}
	}
}


// } Driver Code Ends


class Solution{
    
    // arr: input array
    // n: size of array
    // Function to find the trapped water between the blocks.
    static long trappingWater(int arr[], int n) { 
        // Your code here
        int[] mxl = new int[n];
        int[] mxr = new int[n];
        int mx1 = arr[0];
        int mx2 = arr[n-1];
        for(int i = 0; i < n ; i++){
            mx1 = Math.max(mx1,arr[i]);
            mxl[i] = mx1;
            mx2 = Math.max(mx2,arr[n-i-1]);
            mxr[n-i-1] = mx2;
        }
    
        long ans = 0;
        for(int i = 0 ; i < n ; i++){
            long water = (Math.min(mxl[i],mxr[i]) - arr[i])*1L;
            if(water>=0)
            ans+=water;
        }
        return ans;
    } 
}


