class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>q = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<stones.length;i++)
            q.add(stones[i]);
        while(q.size()>1)
        {
            int x= q.remove();
            int y= q.remove();
            if(x!=y)
                q.add(x-y);  
        }
        if(q.size()==1)
            return q.peek();
        else
            return 0;
    }
}