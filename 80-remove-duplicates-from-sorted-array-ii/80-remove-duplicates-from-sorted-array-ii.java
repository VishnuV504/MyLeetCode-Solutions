class Solution {
    public int removeDuplicates(int[] arr) {
        int count=0;  int count2=1;
        for(int i=0;i<arr.length-1;i++)
        {
            if(arr[i]==arr[i+1]&& count==0)
                count++;
            else if(arr[i]!=arr[i+1])
                count=0;
            else
                arr[i]=100000;
            if(arr[i]!=100000)
                count2++;
        }
        
        // for(int i=0;i<arr.length;i++)
        //     System.out.println(arr[i]);
        int i=0;int j=0;
        while(j!=arr.length)
        {
            if(arr[i]!=100000 && arr[j]!=100000)
            {
                i++;j++;
            }
            else if(arr[i]==100000 && arr[j]==100000)
            {
                j++;
            }
            else if(arr[i]==100000 && arr[j]!=100000)
            {
                arr[i]=arr[j];
                arr[j]=100000;
                i++;j++;
            }
        }
        return count2;
    }
}