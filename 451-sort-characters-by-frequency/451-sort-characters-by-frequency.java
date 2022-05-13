class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(hs1.containsKey(nums[i]))
                hs1.put(nums[i],hs1.get(nums[i])+1);
            else
                hs1.put(nums[i],1);
        }
        PriorityQueue<Pair<Integer,Integer>>minHeap = new PriorityQueue<Pair<Integer,Integer>>(k,Comparator.comparing(Pair::getKey));
        for(Integer Key :hs1.keySet())
        {
            if(minHeap.size()<k)
            {
                int num=hs1.get(Key);
                minHeap.add(new Pair<Integer,Integer>(num,Key));
            }
            else if(minHeap.peek().getKey()<hs1.get(Key))
            {
                minHeap.remove();
                int num=hs1.get(Key);
                minHeap.add(new Pair<>(num,Key));
            }
            //System.out.println(minHeap.peek().getKey());
        }
        int ans[] = new int[k];
        int j=0;
        while(minHeap.size()!=0)
        {
            ans[j++]=minHeap.peek().getValue();
            minHeap.remove();
        }
        return ans;
        
    }
}