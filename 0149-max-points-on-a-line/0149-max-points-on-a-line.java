class Solution {
    public int maxPoints(int[][] points) {
        int ans = 1;
        for(int i = 0 ; i < points.length ; i++){
          double x1 = (double)points[i][0];
          double y1 = (double)points[i][1];
          for(int j = i+1 ; j < points.length ; j++){
            int streak = 2;
            double x2 = (double)points[j][0];
            double y2 = (double)points[j][1];
            double slope = (x2-x1!=0)?(y2-y1)/(x2-x1):Double.MAX_VALUE;
            for(int k = j+1 ; k < points.length ; k++){
              double xn = (double)points[k][0];
              double yn = (double)points[k][1];
              double n1_slope = (xn-x1!=0)?(yn-y1)/(xn-x1):Double.MAX_VALUE;
              double n2_slope = (xn-x2!=0)?(yn-y2)/(xn-x2):Double.MAX_VALUE;
              if(n1_slope==slope&&n2_slope==slope) streak++;
            }
           
            ans = Math.max(ans,streak);
          }
        }
      return ans;
    }
}