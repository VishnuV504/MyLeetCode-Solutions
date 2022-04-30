class Solution {
    public int[] minOperations(String boxes) {
        int n=boxes.length();
        int prefixSum[] = new int[n];
        int suffixSum[] = new int[n];
        int countLeft=0;
        if(boxes.charAt(0)=='1') countLeft++;
        for(int i=1;i<n;i++)
        {
            prefixSum[i]=prefixSum[i-1]+countLeft;
                if(boxes.charAt(i)=='1') countLeft++;
        }
        int countRight=0;
        if(boxes.charAt(n-1)=='1') countRight++;
        for(int j=n-2;j>=0;j--)
        {
            suffixSum[j]=suffixSum[j+1]+countRight;
            if(boxes.charAt(j)=='1') countRight++;
        }
        int res[]= new int[n];
        for(int i=0;i<n;i++)
            res[i]=prefixSum[i]+suffixSum[i];
        return res;
        
    }
}