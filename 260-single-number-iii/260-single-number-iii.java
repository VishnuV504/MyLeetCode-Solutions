class Solution {
    public int[] singleNumber(int[] nums) {
        int[] ans= new int[2];
        int xor=0; int n=nums.length;
        for(int i=0;i<n;i++)
            xor^=nums[i];
        
        int count=0;
        for (int i=0;i<32;i++)
        {
            if((xor&(1<<i))== 0)
                count++;
            else
                break;
        }
        //System.out.println(count);
        int first=0; int second=0;
        for(int i=0;i<n;i++)
        {
            if((nums[i]&(1<<count))!=0)
            {
                first^=nums[i];
            }
            else
            {
                second^=nums[i];
                //System.out.println(nums[i]);
            }
        }
        ans[0]=first;
        ans[1]=second;
        return ans;
            
        

        
    }
}