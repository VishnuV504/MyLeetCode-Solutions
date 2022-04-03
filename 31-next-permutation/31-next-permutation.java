class Solution {
    public void nextPermutation(int[] arr) {
        int flag=0;
        int index1=0;
        for(int i=arr.length-2;i>=0;i--) // to findout the breakpoint  ex: 1 3 2 5 4 here 2nd index will change bcoz of everything of it right side is already in increasing order to get the next greater permutation we have to change the index 2 only (it is the breal point)
        {
            if(arr[i]<arr[i+1])
            {
                index1=i;
                flag=1;
                break;
            }
        }
        
        if(flag==0)
        {
            int low = index1;  
            int high = arr.length-1; // to handle edge case Ex: 5 4 3 2 1 you have just reverse the array 1 2 3 4 5
            while(low<high)
            {
                int temp = arr[low]; 
                arr[low]= arr[high];
                arr[high]=temp;
                low++;
                high--;
            }
            return;
        }


        for(int j=arr.length-1;j>=0;j--) // after finding the breakpoint we have to replace it with slightly higher than that travese again from reverse if you find swap that index
        {
            if(arr[j]>arr[index1])
            {
                int temp = arr[j];
                arr[j]= arr[index1];
                arr[index1]=temp;
                break;
            }

        }

        // reverse
        int low = index1+1;  // the intution behind reversing is the elements which are right to the break point is  in increasing order to make the next permutation smaller reverse only that part(break point +1 to arr.length-1)
        int high = arr.length-1;
        while(low<high)
        {
            int temp = arr[low];  
            arr[low]= arr[high];
            arr[high]=temp;
            low++;
            high--;
        }
        
        
    }
}