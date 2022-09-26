class MyCircularQueue {
       int front;
       int rear;
       int[] queue;
       int size;
    public MyCircularQueue(int k) {
        queue = new int[k];
        front = -1;
        rear = -1;
        size = k;
    }
    
    public boolean enQueue(int value) {
         if(isFull()) return false; 
         rear = (rear+1)%size;        
         if(front==-1) front = 0;
         queue[rear] = value;
         return true;
    }
    
    public boolean deQueue() { 
        if(isEmpty()) return false;
        
        if(front==rear){
            front = -1;
            rear = -1;
        }
        else front = (front+1)%size;
        return true;
    }
    
   
    
    public int Front() {
        return front!=-1&&front!=queue.length?queue[front]:-1;
    }
    
    public int Rear() {
        return rear!=-1&&rear!=queue.length?queue[rear]:-1;
    }
    
    public boolean isEmpty() {
        if(front==-1) return true;
        return false;
    }
    
    public boolean isFull() {
        if(front==0&&rear==queue.length-1) return true;
        else if(front == rear+1) return true;
        return false;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */