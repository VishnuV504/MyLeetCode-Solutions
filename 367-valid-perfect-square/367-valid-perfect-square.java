class Solution {
    public boolean isPerfectSquare(int num) {
        if(num==1)
            return true;
        int i=1; int j=num/2;
        while(i<=j)
        {
            int mid=i+(j-i)/2;
            int res=mid*mid;
            if(res/mid !=mid) // if mid overflow 
                j=mid-1;
            else if(res == num)
                return true;
            else if(res<num)
                i=mid+1;      
            else
                j=mid-1;
        }
        return false;
    }
}