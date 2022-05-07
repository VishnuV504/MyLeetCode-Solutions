class Solution {
    public int countPrimes(int n) {
        boolean[] sieve = new boolean[n];
        for(int i=2;i*i<n;i++)
        {
            if(sieve[i]==true) continue;
            for(int j=i*i;j<n;j=j+i)
                sieve[j]=true;
        }
        int count=0;
        for(int i=2;i<n;i++)
            if(sieve[i]==false)count++;
        return count;
        
    }
}