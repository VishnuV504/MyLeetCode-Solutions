class MinStack {
    
    Stack<Integer>st = new Stack<>();
    Stack<Integer>MinStack=new Stack<>();
    public void minStack() {
        return ;
        
    }
    
    public void push(int val) {
        if(MinStack.isEmpty())
            MinStack.push(val);
        else{
            if(val<=MinStack.peek())
                MinStack.push(val);
        }
        st.push(val);
        
    }
    
    public void pop() {
        int val=MinStack.peek();
        if(st.peek()==val)
            MinStack.pop();
        st.pop();
    }
    
    public int top() {
      return st.peek();
    }
    
    public int getMin() {
        return MinStack.peek();
        
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