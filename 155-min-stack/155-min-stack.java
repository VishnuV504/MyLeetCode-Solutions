class MinStack {
    
    Stack<Long>st = new Stack<>();
    long min=Long.MAX_VALUE;
    public void minStack() {
        return ;
    }
    
    public void push(int val) {
        if(st.isEmpty()){
            min=val;
            st.push((long)val);
        }
        else{
            if(val<min){
                st.push(val-min+val);
                min=val;
            }
            else
            st.push((long)val);
        }
        
    }
    
    public void pop() {
        if(st.peek()<min){
            min=2*min-st.peek();
        }
        st.pop();
    }
    
    public int top() {
        if(st.peek()<min)
            return (int)min;
        long ans=st.peek();
      return (int)ans;
    }
    
    public int getMin() {
        return (int)min;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */