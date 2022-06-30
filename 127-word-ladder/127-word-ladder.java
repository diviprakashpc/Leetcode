class Solution {
    class Pair{
        String word;
        int depth;
        Pair(String word , int depth){
            this.word = word;
            this.depth = depth;
        }
    }
    public int ladderLength(String w1, String w2, List<String> wordList) {
        boolean ispresent = false;
        Set<String> set = new HashSet<>();
        for(String s : wordList){
            if(s.equals(w2)) {
                ispresent = true;
            }
            set.add(s);
        }
        if(ispresent==false) return 0;
        
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(w1,0));
        while(!q.isEmpty()){
              
            int size = q.size();
            while(size-->0){
                Pair p = q.remove();
             
                for(int i = 0 ; i < p.word.length() ; i++){
                   String curr = p.word;
                    for(char j = 'a' ; j <= 'z' ; j++){
                        curr = curr.substring(0,i) + j + curr.substring(i+1);
                        if(curr.equals(p.word)) continue;
                        else if(curr.equals(w2)) return p.depth+2;
                        else if(set.contains(curr)){
                            String toadd = curr;
                            q.add(new Pair(toadd,p.depth+1));
                            set.remove(toadd);
                        }
                    }
                }
             
            }
        }
        return 0 ;
    }
}