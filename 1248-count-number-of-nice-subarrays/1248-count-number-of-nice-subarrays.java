class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int x=solve(nums,k);
        k--;
        int y=0;
        if(k!=0)
        y= solve(nums,k);
        return x-y;
    }
    private int solve(int nums[],int k)
    {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int j=0; int count=0; int prev=0; int n= nums.length;
        int totalCount=0;
        for(int i=0;i<n;i++)
        {
            while((nums[i]&1)==1&&count==k)
            {
                if(hs1.get(nums[j])==1)
                    hs1.remove(nums[j]);
                else
                    hs1.put(nums[j],hs1.get(nums[j])-1);
                if((nums[j]&1)==1) count--;
                j++;
            }
            if(hs1.containsKey(nums[i]))
                hs1.put(nums[i],hs1.get(nums[i])+1);
            else
                hs1.put(nums[i],1);  
            if((nums[i]&1)==1)
            {
                count++;
                totalCount+=i-j+1;
                prev=i-j+1;
            }
            else
                totalCount+=prev;
           // System.out.println(totalCount);   
        }
        return totalCount;
    }
}