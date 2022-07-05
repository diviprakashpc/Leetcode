class Solution {
    public boolean canIWin(int high, int total) {
         int sum = (1+high)*high/2;
        if(sum < total) return false;
        if(total <= 0) return true;
        boolean[] used = new boolean[high+1];
        HashMap<Integer,Boolean> map = new HashMap<>();
        return helper(high,total,used,map);
        
    }
    
    public boolean helper(int high , int total , boolean[] visited,HashMap<Integer,Boolean> map){
         if(total <= 0) return false;
        int key = genkey(visited);
        
        if(!map.containsKey(key)){
            for(int i = 1;  i <=high ; i++){
                if(!visited[i]){
                    visited[i] = true;
                   boolean b = helper(high,total-i,visited,map);
                    if(!b){
                        map.put(key,true);
                        visited[i] = false;
                        return true;
                    }
                    visited[i] = false;
                }
            }
            map.put(key,false);
        }
        return map.get(key);
    }
    
    public int genkey(boolean[] used){
       int num = 0;
        for(boolean b: used){
            num <<= 1;
            if(b) num |= 1;
        }
        return num;
    }
}