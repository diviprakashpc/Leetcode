class Solution {
    public String frequencySort(String s) {
        char[] freq = new char[256];
        for(int i = 0 ; i < s.length() ; i++){
          freq[s.charAt(i)-'0']++;
        }
       
       PriorityQueue<Pair> pq = new PriorityQueue<>();
      for(int i = 0 ; i < s.length() ; i++){
          Pair p = new Pair(s.charAt(i),freq[s.charAt(i)-'0']);
         pq.add(p);
      }
      
      StringBuilder res = new StringBuilder("");
      while(!pq.isEmpty()){
        res.append(pq.remove().elem);
      }
       return res.toString();
    }
  
  static class Pair implements Comparable<Pair>{
    char elem;
    int freq;
    Pair(char e , int f){
      elem = e;
      freq = f;
    }
    
    public int compareTo(Pair p){
      return (p.freq!=this.freq)?p.freq - this.freq:p.elem - this.elem;
    }
  }
}