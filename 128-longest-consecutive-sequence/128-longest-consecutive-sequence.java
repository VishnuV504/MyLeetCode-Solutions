class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer>hs1 = new LinkedHashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++) hs1.put(nums[i],0);
        int longest=0;
        for(Integer key:hs1.keySet()){
           int num=key;int curr=0;
            while(hs1.containsKey(num)){
                if(hs1.get(num)!=0){
                    curr+=hs1.get(num);
                    break;
                }
                curr++;num++;
            }
            hs1.put(key,curr);
            longest=Math.max(longest,curr);
        }
        return longest;
    }
}