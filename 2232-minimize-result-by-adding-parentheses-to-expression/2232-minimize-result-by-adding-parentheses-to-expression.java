class Solution {
    public int reverse(int num)
    {
        int res=0;
        while(num>0)
        {
            res=res*10+num%10;
            num/=10;
        }
        return res;
    }
    public String minimizeResult(String expression) {
        
        String s= expression;
        int leftBraceIndex=-1; int rightBraceIndex=-1;
        int OverAllRes=Integer.MAX_VALUE;
        int i=0;
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='+')
                break;
        }
        int plus=i;
        int left=0;int leftBrace=-1; int rightBrace=-1;
        for(int j=plus-1;j>=0;j--)
        {
            leftBrace=j;
            left=left*10+Character.getNumericValue(s.charAt(j));
            int left1 = reverse(left);
            //System.out.println(left1+" "+"l");
            int leftP=0;
            for(int k=0;k<j;k++)
                leftP=leftP*10+Character.getNumericValue(s.charAt(k));
                        //System.out.println(leftP+" "+ "lp");
            int right=0;
            for(int l=plus+1;l<s.length();l++)
            {
                right=right*10+Character.getNumericValue(s.charAt(l));
                //System.out.println(right +" "+ "r");
                int rightP=0;
                rightBrace=l;
                for(int m=l+1;m<s.length();m++)
                rightP=rightP*10+Character.getNumericValue(s.charAt(m));
                //System.out.println(rightP+" "+"rp");
                int res=0;
                if(leftP==0 && rightP==0)
                    res=(left1+right);
                else if(leftP==0 && rightP!=0)
                    res=(left1+right)*rightP;
                else if(rightP==0 && leftP!=0)
                    res=(left1+right)*leftP;
                else
                 res=leftP*(left1+right)*rightP;
                //System.out.println(res+" "+"res");
                if(res<OverAllRes)
                {
                    leftBraceIndex=leftBrace;
                    rightBraceIndex=rightBrace+1;
                    OverAllRes=res;
                }
            }
        }
        //System.out.println(leftBraceIndex+" "+rightBraceIndex+" index");
        char[] a = new char[s.length()+2];
        a[leftBraceIndex]='(';
        a[rightBraceIndex+1]=')';
        //System.out.println(a[rightBraceIndex]+" "+a[leftBraceIndex]);
        int n=0;
        for(int k=0;k<a.length;k++)
        {
            if(a[k]!='(' && a[k]!=')')
            {
                a[k]=s.charAt(n);
                n++;
            }
            //System.out.println(a[k]);
        }
        String ans = new String(a);  
        return ans;
        
    }
}