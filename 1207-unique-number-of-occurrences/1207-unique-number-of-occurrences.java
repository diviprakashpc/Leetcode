class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0 ; i < arr.length ; i++){
          map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        Set<Integer> hs = new HashSet<>();
        for(int i : map.keySet()){
           hs.add(map.get(i));
        }
      
      return hs.size()==map.size();
    }
}