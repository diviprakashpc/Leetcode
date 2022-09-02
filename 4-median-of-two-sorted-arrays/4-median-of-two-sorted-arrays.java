   class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
       int totalelem = a.length + b.length;
        if(a.length > b.length){
            int[] temp = a;
            a = b;
            b = temp;
        }
       int start = 0;
       int end = a.length;
       while(start<=end){
           int m = start + (end-start)/2;
           int p1 = (m>0)?a[m-1]:Integer.MIN_VALUE;
           int p2 = (m>=a.length)?Integer.MAX_VALUE:a[m];
           int idxb = ((totalelem+1)/2-m);
           int p3 = (idxb>=b.length)?Integer.MAX_VALUE:b[idxb];
           int p4 = (idxb>0) ? b[idxb-1] : Integer.MIN_VALUE;
           
           if(p1<=p3&&p4<=p2){
               double median = 0;
               if(totalelem%2==0){
                   int a1 = Math.max(p1,p4);
                   int a2 = Math.min(p2,p3);
                   median = (a1+a2);
                   median = median/2.0;
                   return median;
               }else{
                   int a1 = Math.max(p1,p4);
                   median = a1;
                   return median;
               }
           }
           else if(p1>p3){
               end = m - 1;
           }
           else start = m + 1;
       }
        
        return -1;
    }
}