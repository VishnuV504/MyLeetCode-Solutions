class Solution {
    public int longestConsecutive(int[] nums) {
        LinkedHashMap<Integer,Integer>hs1 = new LinkedHashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++) hs1.put(nums[i],0);
        int longest=0;
        for(Integer key:hs1.keySet()){
           int curr=0;
            if(hs1.get(key)!=0)
                curr=hs1.get(key);
            else
                curr=solve(key,hs1);
            longest=Math.max(longest,curr);
        }
        return longest;
    }
    private int solve(int num,LinkedHashMap<Integer,Integer>hs1){
        if(!hs1.containsKey(num))return 0;
        if(hs1.get(num)!=0)return hs1.get(num);
        hs1.put(num,1+solve(num+1,hs1));
        return hs1.get(num);
    }
}