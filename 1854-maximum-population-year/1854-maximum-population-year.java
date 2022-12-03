class Solution {
    public int maximumPopulation(int[][] logs) {
        TreeMap<Integer,Integer> map = new TreeMap<>();
       for(int[] log : logs){
          int b = log[0];
          int d = log[1];
          map.put(b,map.getOrDefault(b,0)+1);
          map.put(d,map.getOrDefault(d,0)-1);
       }
      int pop = 0;
      int max = 0;
      int ans = 0;
      for(int key : map.keySet()){
          pop +=map.get(key);
        if(pop>max){
          max = pop;
          ans = key;
        }
         }
      return ans;
      }
    }
