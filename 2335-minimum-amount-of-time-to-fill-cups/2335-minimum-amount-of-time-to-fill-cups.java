class Solution {
    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        int rem=amount[2]-amount[1];
        if(amount[0]<=rem)
            return amount[2];
        else{
            amount[0]-=rem;
            if(amount[0]%2==0)
                return amount[2]+amount[0]/2;
            return amount[2]+(amount[0]/2)+1;
        }
        
    }
}