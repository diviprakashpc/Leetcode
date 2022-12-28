//{ Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++){
                nums[i] = Integer.parseInt(S[i]);
            }
            Solution obj = new Solution();
            int ans = obj.minSwaps(nums);
            System.out.println(ans);
       }
    }
}
// } Driver Code Ends




class Solution
{
    //Function to find the minimum number of swaps required to sort the array.
    public int minSwaps(int nums[])
    {
        // Code here
        int n = nums.length;
        int[] dummy = new int[nums.length];
        for(int i = 0 ;  i < n ; i++){
           dummy[i] = nums[i]; 
        }
        Arrays.sort(dummy);
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ;  i < nums.length;i++) map.put(nums[i],i);
        int swaps = 0;
        for(int i = 0  ; i  < nums.length ; i++){
           if(nums[i]!=dummy[i]){
               int idx = map.get(dummy[i]);
               int temp =  nums[i];
               nums[i] = nums[idx];
               nums[idx] = temp;
               map.put(temp,idx);
               map.put(nums[i],i);
               swaps++;
           }
        }
        return swaps;
    }
}