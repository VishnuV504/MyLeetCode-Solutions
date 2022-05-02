class Solution {
    int max=0;
    public int maxLength(List<String> arr) {
        int n=arr.size();
        char arr2[] = new char[26];
        solve(0,arr,n,0,arr2);
        return max;
    }
    private void solve(int curr,List<String>arr,int n,int len,char[] arr2)
    {
            if(curr==n)
            {
                max=Math.max(len,max);
                return;
            }
            boolean flag=false;
            for(int j=0;j<arr.get(curr).length();j++)
            {
                if(arr2[(int)(arr.get(curr).charAt(j)-'a')]>=1)
                {
                    flag=true;
                }
                arr2[(int)(arr.get(curr).charAt(j)-'a')]++;
                    
            }
            if(flag==false)
            solve(curr+1,arr,n,len+arr.get(curr).length(),arr2);
            for(int j=0;j<arr.get(curr).length();j++)
            {
                    arr2[(int)(arr.get(curr).charAt(j)-'a')]--;
                    
            }
            solve(curr+1,arr,n,len,arr2);
    }
}