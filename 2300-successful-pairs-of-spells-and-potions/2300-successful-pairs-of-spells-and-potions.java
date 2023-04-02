class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] res = new int[spells.length];
        Arrays.sort(potions);
        int k = 0;
        for(int i = 0 ; i  < spells.length ; i++){
            long spell = spells[i]*1L;
            res[k++] = getCount(spell,potions,success);
        }
        return res;
    }
    
    public int getCount(long spell , int[] p ,  long succ){
        int s = 0;
        int e = p.length-1;
        while(s<=e){
            int m = (s) + (e-s)/2;
            long mul = spell*p[m]*1L;
            if(mul>=succ){
                e = m-1;
            }else{
                s = m+1;
            }
        }
       return p.length - s;    
    }
    
        
}