class Solution {
    public int countArrangement(int n) {
        int count[] = new int[1];
        int mask=0;
        solve(n,count,0,mask);
        return count[0];
        
    }
    private void solve(int n, int count[],int occur,int mask)
    {
        if(occur==n)
        {
            count[0]++;
            return;
        }
        for(int i=1;i<=n;i++)
        {
            if((mask&1<<i)!=0) continue;
            else if(i%(occur+1)==0 ||(occur+1)%i==0)
            {
                mask|=1<<i;
                solve(n,count,occur+1,mask);
                mask^=1<<i;
            }
        }
    }
    
}