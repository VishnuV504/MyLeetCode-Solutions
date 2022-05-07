class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count=0;HashMap<Integer,Integer>hs1 = new HashMap<>();
        int num=0; int n=nums.length;
        hs1.put(0,1);
        for(int i=0;i<n;i++)
        {
            num=(num+((nums[i]%k+k)%k))%k;
            if(hs1.containsKey(num))
            {
                count+=hs1.get(num);
                hs1.put(num,hs1.get(num)+1);
            }
            else
                hs1.put(num,1); 
        }
        return count;
    }
}