class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        long prefixSum=0; long pSum=0; int n=heights.length; int size=0;
        PriorityQueue<Integer>pq= new PriorityQueue<Integer>();
        for(int i=1;i<n;i++)
        {
            if(heights[i-1]>=heights[i])continue;
            int diff=heights[i]-heights[i-1];
            prefixSum+=diff;
            if(size<ladders)
            {
                pq.add(diff);
                ++size;
                pSum+=diff;
            }
            else
            {
                if(!pq.isEmpty()&&pq.peek()<diff)
                {
                    pSum-=pq.peek();
                    pq.remove();
                    pq.add(diff);
                    pSum+=diff;
                }
                if(prefixSum-pSum>bricks)return i-1;       
            } 
        }
        return n-1;
        
    }
}