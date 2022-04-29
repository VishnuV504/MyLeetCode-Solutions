class Solution {
    public int minMoves(int target, int maxDoubles) {
        int count=0;
        while(target>1)
        {
            if((target&1)==1)
            {
                target--;
                count++;  
            }
            else if(maxDoubles!=0 && target/2>0)
            {
                count++;
                target/=2;
                maxDoubles--;
                
            }
            else
            {
                target--;
                count++;
            }
            if(maxDoubles==0)
                break;
        }
        return count+target-1;
    }
}