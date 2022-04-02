class Solution {
    public int minSteps(int n) {
        if(n==1)
            return 0;
        return 1+fewSteps(1,n,1,false);  // 1+ is for because first time copy should be done 
        
    }
    private int fewSteps(int curr, int n,int prevCopied,boolean flag)
    {
        if(curr==n)
            return 0;
        if(curr>n)
            return 10000;
        int copy=10000;
        int paste=10000;
        if(flag==false)
            copy=1+fewSteps(curr,n,curr,true);
        paste = 1+fewSteps(curr+prevCopied,n,prevCopied,false);
        return Math.min(copy,paste);
    }
}