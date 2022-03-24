class Solution {
    public int[] plusOne(int[] digits) {
        int flag=0;
        for(int i=digits.length-1;i>=0;i--)
        {
            if(digits[i]!=9)
            {
                digits[i]+=1;
                flag=1;
                break;
            }
            else
            {
                digits[i]=0;
            }
        }
        if(flag==1)
            return digits;
        int result[] = new int[digits.length+1];
        result[0]=1;
        for(int i=1;i<result.length;i++)
        {
            result[i]=digits[i-1];
        }
        return result;
        
    }
}