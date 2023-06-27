//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer> ans = new ArrayList<>();
        int r1=0 , c1 = 0;
        int r2 = r-1;
        int c2 = c-1;
        while(true){
            for(int i = c1 ; i<=c2 ; i++){
                ans.add(matrix[r1][i]);
            }
            r1++;
            if(r1>r2) break;
            for(int i = r1 ; i<=r2 ; i++){
                ans.add(matrix[i][c2]);
            }
            c2--;
            if(c1>c2) break;
            
            for(int i = c2 ; i >=c1; i--){
                ans.add(matrix[r2][i]);
            }
            r2--;
             if(r1>r2) break;
            for(int i = r2 ; i>=r1 ;i--){
                ans.add(matrix[i][c1]);
            }
            c1++;
            if(c1>c2) break;
        }
        return ans;
    }
}
