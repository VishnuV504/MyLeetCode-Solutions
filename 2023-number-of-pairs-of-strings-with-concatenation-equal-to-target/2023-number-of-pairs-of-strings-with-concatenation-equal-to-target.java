class Solution {
    public int numOfPairs(String[] nums, String target) {
        HashMap<String,Integer>freq = new HashMap<>();
        int m=nums.length;
        int n=target.length();
        for(int i=0;i<m;i++)
        {
            if(freq.containsKey(nums[i]))
                freq.put(nums[i],freq.get(nums[i])+1);
            else
                freq.put(nums[i],1);
        }
        //generate prefix and serach for suffix
        int count=0;
        for(int i=0;i<n;i++)
        {
            String prefix=target.substring(0,i+1);
            String suffix=target.substring(i+1,n);
            //System.out.println(prefix+" "+suffix);
            if(freq.containsKey(prefix)&& freq.containsKey(suffix))
            {
               if(prefix.equals(suffix)) count+=freq.get(prefix)*(freq.get(suffix)-1);
                else
                count+=freq.get(prefix)*freq.get(suffix);
            }  
        }
         return count;
    }
}