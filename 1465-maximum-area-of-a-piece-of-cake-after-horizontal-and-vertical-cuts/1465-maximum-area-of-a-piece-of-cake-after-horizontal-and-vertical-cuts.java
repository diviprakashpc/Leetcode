class Solution {
    int mod = (int)1e9 + 7;
    public int maxArea(int h, int w, int[] hc, int[] vc) {
       long i = 0;
       long j = 0;
       long maxArea = Long.MIN_VALUE;
        Arrays.sort(hc);
        Arrays.sort(vc);
       long tempi = i;
       long tempj = j;  
        long area = 0;
        for(int k = 0 ; k < hc.length ; k++ ){
            tempi = tempj;
            tempj = hc[k];
             area = (tempj-tempi)*w;
            if(area>maxArea){
            i = tempi;
            j = tempj;
                maxArea = area;
            }
           
        }
        //  System.out.println("area and max area "+ area + " "+ maxArea);
            tempi = tempj;
            tempj = h;
             area = (tempj-tempi)*w;
            if(area>maxArea){
            i = tempi;
            j = tempj;
                maxArea = area;
            }
       //   System.out.println("area and max area "+ area + " "+ maxArea);
        long k = 0;
        long l = 0;
        maxArea = Integer.MIN_VALUE;
        tempi = k;
        tempj = l;
        
        for(int t = 0 ; t < vc.length ; t++){
            tempi = tempj;
            tempj = vc[t];
             area = (tempj-tempi)*h;
            if(area>maxArea){
                k = tempi;
                l = tempj;
                maxArea = area;
            }
        }
    //      System.out.println("area and max area "+ area + " "+ maxArea);
        tempi = tempj;
        tempj = w;
         area = (tempj-tempi)*h;
          if(area>maxArea){
                k = tempi;
                l = tempj;
              maxArea = area;
            }
     //     System.out.println("area and max area "+ area + " "+ maxArea);
        return (int)((j-i)%mod * (l-k)%mod)%mod;
        
        
        
    }
}