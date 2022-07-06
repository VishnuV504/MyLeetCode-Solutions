class Solution {
    public int fib(int n) {
        if(n<2)return n;
        int prevPrev=0; int prev=1; int curr=0;
        for(int i=2;i<=n;i++){
            curr=prevPrev+prev;
            prevPrev=prev;
            prev=curr;
        }
        return curr; 
    }
}