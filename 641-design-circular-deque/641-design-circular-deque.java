class MyCircularDeque {
         int front;
         int rear;
         int[] arr;
         int size;
    public MyCircularDeque(int k) {
        front = -1;
        rear = -1;
        size = k;
        arr = new int[k];
    }
    
    public boolean insertFront(int value) {
        if((front==0&&rear==size-1)||(front==rear+1)) return false;
        else if(front==-1&&rear==-1){
          front = 0;
          rear = 0;
          arr[front] = value;
        }
        else if(front==0){
          front = size - 1;
          arr[front] = value;
        }else{
          front--;
          arr[front] = value;
        }
      return true;
    }
    
    public boolean insertLast(int value) {
        
        if((front==0&&rear==size-1)||(front==rear+1)) return false;
  
        if(rear==-1){
           front = 0;
           rear = 0;
           arr[rear] = value;
       }
      
        else if(rear==size-1){
          rear = 0;
          arr[rear] = value;
       }
      
        else{
           rear++;
          arr[rear] = value;
         
       }
         return true;
    }
    
    public boolean deleteFront() {
        if(front==-1) return false;
       if(front==rear){
         front = -1;
         rear = -1;
       }
        else if(front==size-1) {
          front = 0;
        }
        else{
          front++;
        }
      return true;
    }
    
    public boolean deleteLast() {
        if(rear==-1) return false;
        if(front==rear) {
          front = -1;
          rear = -1;
        }
        else if(rear==0) rear = size-1;
      else rear--;
      return true;
    }
    
    public int getFront() {
        return (front==-1) ? -1 : arr[front];
    }
    
    public int getRear() {
        return (rear==-1) ? -1 : arr[rear];
    }
    
    public boolean isEmpty() {
        if(front==-1) return true;
         if(rear==-1) return true;
        return false;
    }
    
    public boolean isFull() {
          if((front==0&&rear==size-1)||(front==rear+1)) return true;
      return false;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */