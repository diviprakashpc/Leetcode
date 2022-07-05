class LRUCache {
       int capacity;
       int size;
       Node head;
       Node tail;
       HashMap<Integer,Node> map;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        head  = new Node(-1,-1,null,null);
        tail = new Node(-1,-1,null,null);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            insert(n);
            return n.value;
        }else{
            return -1;
        }
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n); 
        }
         
         if(map.size()==capacity){
             remove(tail.prev);
         }
        
            Node n = new Node(key,value,null,null);
            insert(n);
    }
    
    private void insert(Node n){
           map.put(n.key,n);
           Node temp = head.next;
            head.next = n;
            n.prev = head;
            temp.prev = n;
            n.next = temp;
    }
    
    private void remove(Node n){
        map.remove(n.key);
        n.prev.next = n.next;
        n.next.prev= n.prev;
    }
}

class Node{
    int key;
    int value;
    Node next;
    Node prev;
    Node(int key,int value , Node next, Node prev){
        this.key = key;
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */