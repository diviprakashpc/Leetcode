class MedianFinder {
      PriorityQueue<Integer> min;
      PriorityQueue<Integer> max;
    public MedianFinder() {
        max = new PriorityQueue<>();
        min = new PriorityQueue<>((a,b)->b-a);
    }
    
    public void addNum(int num) {
        if(min.isEmpty()){
            min.add(num);
        }
        else if(num>min.peek()){
            max.add(num);
            if(max.size()>min.size()+1){
                min.add(max.remove());
            }
        }else{
            min.add(num);
            if(min.size()>max.size()+1){
                max.add(min.remove());
            }
        }
    }
    
    public double findMedian() {
        if(min.size()==max.size()){
            return ((double)min.peek()+(double)max.peek())/2.0;
        }
        return (min.size()>max.size()) ? min.peek() : max.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */