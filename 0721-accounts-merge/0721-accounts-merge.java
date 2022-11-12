class Solution {
    int[] par;
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        par = new int[(int)1e5+1];
        for(int i = 0 ; i < par.length;i++) par[i] = i;
        
        HashMap<String,Integer> euid = new HashMap<>();  //email to unique id
         HashMap<String,String> etn = new HashMap<>();  //email to name
        int uid = 0;
       
        for(List<String> account : accounts){
           String name = "";
           for(String email : account){
             if(name.equals("")) {
                 name = email;
                 continue;
             }
             if(!etn.containsKey(email)){
                etn.put(email,name);
             }
            if(!euid.containsKey(email)){
                euid.put(email,uid);
               uid++;
             }
             int fuid = euid.get(account.get(1));
             int curruid = euid.get(email);
             
             int p1 = find(fuid);
             int p2 = find(curruid);
             
             if(p1!=p2){
                par[p2] = p1;
             }
           }
        }
      
        HashMap<Integer,List<String>> pte = new HashMap<>();
        for(String email : euid.keySet()){
            int parent = find(euid.get(email));
            if(pte.containsKey(parent)){
                 pte.get(parent).add(email);
            }else{
                 pte.putIfAbsent(parent,new ArrayList<>());
                 pte.get(parent).add(email);
            }
        }
      //System.out.println(etn);
     // System.out.println(pte);
     // System.out.println(euid);
        
        List<List<String>> ans = new ArrayList<>();
        for(List<String> emails : pte.values()){
          Collections.sort(emails);
           String holder = etn.get(emails.get(0));
           List<String> temp = new ArrayList<>();
           temp.add(holder);
           for(String e : emails){
             temp.add(e);
           }
          ans.add(temp);
        }
      return ans;
    }
  
  public int find(int u){
    if(u==par[u]) return u;
    return par[u] = find(par[u]);
  }
  
  public void union(int u , int v){
    int p1 = find(u);
    int p2 = find(v);
    if(p1!=p2) {
      par[u] = v;
    }
  }
}