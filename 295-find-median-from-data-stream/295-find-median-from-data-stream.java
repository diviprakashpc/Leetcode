class MedianFinder {
      PriorityQueue<Integer> min;
      PriorityQueue<Integer> max;
    public MedianFinder() {
        min = new PriorityQueue<>();
        max = new PriorityQueue<>((a,b)->b-a); //glati se ulta min-max krke submit kr diya tha. Ye wala sahi h ab.
    }
    
    public void addNum(int num) {
        if(max.isEmpty()){
            max.add(num);
        }
        else if(num>max.peek()){
            min.add(num);
            if(min.size()>max.size()+1){
                max.add(min.remove());
            }
        }else{
            max.add(num);
            if(max.size()>min.size()+1){
                min.add(max.remove());
            }
        }
    }
    
    public double findMedian() {
        if(min.size()==max.size()){
            return ((double)min.peek()+(double)max.peek())/2.0;
        }
        return (max.size()>min.size()) ? max.peek() : min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */