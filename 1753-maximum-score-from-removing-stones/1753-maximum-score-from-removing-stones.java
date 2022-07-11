class Solution {
    public int maximumScore(int a, int b, int c) {
        int amount[]={a,b,c};
        Arrays.sort(amount);
        int rem=amount[2]-amount[1];
        if(amount[0]<=rem)
            return amount[0]+amount[1];
        else{
            amount[0]-=rem;
            return amount[2]+amount[0]/2;
        }

        
    }
}