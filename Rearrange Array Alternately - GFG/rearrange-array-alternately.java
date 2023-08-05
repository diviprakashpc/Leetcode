//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main (String[] args)throws IOException
	{

// 		Scanner in = new Scanner(System.in);
        
// 		int t = in.nextInt();
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        
         //testcases
        int t = Integer.parseInt(read.readLine());
		
		while(t-- >0)
		{
		    //size of array
		    int n = Integer.parseInt(read.readLine());
		    long[] arr= new long[n];
		    
		    String str[] = read.readLine().trim().split(" ");
		    
		    //adding elements to the array
		    for(int i=0;i<n;i++)
		        arr[i] = Long.parseLong(str[i]);
		    
		    // StringBuffer sb = new StringBuffer();
		    
		    Solution ob = new Solution();
		    
		    //calling rearrange() function
		    ob.rearrange(arr, n);
		    StringBuffer sb = new StringBuffer();
		    
		    //appending and printing the elements
		    for(int i =0; i < n; i++)
		     sb.append(arr[i] + " ");
		    System.out.println(sb);
		}
	}
}




// } Driver Code Ends


class Solution{
    
    // temp: input array
    // n: size of array
    //Function to rearrange  the array elements alternately.
    public static void rearrange(long arr[], int n){
        
        // Your code here
        long mx = 0;
        for(long l : arr){
            mx = Math.max(mx,l);
        }
        mx = mx + 1;
        int j = 0;
        int k = n-1;
        for(int i = 0 ; i < n ; i++){
            if(i%2==0){
                arr[i] = arr[i] + (arr[k]%mx)*mx;
                k--;
            }else{
                arr[i] = arr[i]+ (arr[j]%mx)*mx;
                j++;
            }
        }
        
        for(int i = 0 ; i <  n ; i++){
            arr[i] = arr[i]/mx;
        }
        
        return;
        
    }
    
}

//We are doing %mx because,
// [1,2,3,4,5,6,7,8,9]
// when i = 1, arr[i] = arr[i] + (arr[j])*mx  if we dont do %mx.
// thereore arr[1] = arr[1] + (arr[0])*mx;
// Then arr[1] = 2 + (1+9*mx)*mx . This is because during i = 0  arr[0] got updated.
//But orignally we wanted arr[1] = 2 + 1*mx , so later we can devide by mx and take out 1 at i= 1
// So as to extract 1 from this 1+9*mx... we do %mx also.


