class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        double xoverlap = Math.min(bx2,ax2) - Math.max(bx1,ax1);
        double yoverlap = Math.min(by2,ay2) - Math.max(by1,ay1);
        double overlap = (xoverlap>0&&yoverlap>0) ? xoverlap * yoverlap : 0;
        double a1 = Math.abs(ax2-ax1) * Math.abs(ay2 - ay1);
        double a2 = Math.abs(bx2-bx1) * Math.abs(by2-by1);
        
      return (int)a1 + (int)a2 - (int)overlap;
    }
}