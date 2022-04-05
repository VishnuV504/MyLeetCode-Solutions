class Solution {
    public int mySqrt(int x) {
        
        int i=1; int j = x;
        while(i<=j)
        {
            int mid = i+(j-i)/2;
            int res = mid*mid;
            if(mid!=res/mid)
                j=mid-1;
            else if(mid*mid==x)
                return mid;
            else if(mid*mid>x)
                j=mid-1;
            else 
                i=mid+1;
        }
        return i-1;
        
    }
}