class MedianFinder {
    PriorityQueue<Integer>minHeap = new PriorityQueue<>();
    PriorityQueue<Integer>maxHeap = new PriorityQueue<>(Collections.reverseOrder());
    public MedianFinder() {
        return;
    }
    
    public void addNum(int num) {
        if(minHeap.size()==maxHeap.size()){
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
        }
        else{
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
        }
    }
    
    public double findMedian() {
        if(minHeap.size()==maxHeap.size())
            return (minHeap.peek()+maxHeap.peek())/2.0;
        return (double)minHeap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */