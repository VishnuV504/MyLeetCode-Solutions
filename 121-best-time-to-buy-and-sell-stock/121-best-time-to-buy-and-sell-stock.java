class Solution {
    public int maxProfit(int[] prices) {
        Stack<Integer>st1 = new Stack<Integer>();
        int profit=0;
        int maxProfit=0;
        for(int i=prices.length-1;i>=0;i--)
        {
            if(st1.empty())
            {
                profit=0;
                st1.push(prices[i]);
            }
            else
            {
                if(st1.peek()>prices[i])
                {
                    profit= st1.peek()-prices[i];
                }
                else
                {
                    st1.push(prices[i]);
                }
            }
            
            if(profit>maxProfit)
            maxProfit=profit;
        }
        return maxProfit;
        
    }
}