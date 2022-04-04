class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n= temperatures.length;
        int result[] = new int[n];
        Stack<Integer>ngr = new Stack<Integer>();
        for(int i=n-1;i>=0;i--)
        {
            if(ngr.size()==0)
            {
                result[i]=0;
                ngr.push(i); 
            }
            else if(temperatures[i]<temperatures[ngr.peek()])
            {
                result[i]=ngr.peek()-i;
                ngr.push(i);
            }
            else
            {
                while(ngr.size()!=0 && temperatures[i]>=temperatures[ngr.peek()])
                    ngr.pop();
                if(ngr.size()==0)
                {
                    result[i]=0;
                    ngr.push(i); 
                }
                else
                {
                    result[i]=ngr.peek()-i;
                    ngr.push(i);
                }
            }
        }
        return result;
        
    }
}