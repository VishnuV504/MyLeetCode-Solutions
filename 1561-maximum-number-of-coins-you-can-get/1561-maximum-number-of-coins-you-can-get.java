class Solution {
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int ans=0; int n=piles.length;
        int m=n/3;
        for(int i=n-2;i>=m;i=i-2)
            ans+=piles[i];
        return ans;
        
    }
}