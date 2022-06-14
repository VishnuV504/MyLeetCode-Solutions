class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        return solve(rooms);
    }
    private boolean solve(List<List<Integer>>rooms)
    {
        int n=rooms.size(); boolean visited[]= new boolean[n];
        Queue<Integer>q = new LinkedList<>(); int count=1;
        visited[0]=true;
        for(int i=0;i<rooms.get(0).size();i++)
        {
            if(!visited[rooms.get(0).get(i)])
            {
                q.add(rooms.get(0).get(i));
                visited[rooms.get(0).get(i)]=true; 
                count++;
            }
        }
        while(!q.isEmpty())
        {
            int ans=q.remove();
            for(int i=0;i<rooms.get(ans).size();i++)
            {
                if(!visited[rooms.get(ans).get(i)])
                {
                    visited[rooms.get(ans).get(i)]=true;
                    q.add(rooms.get(ans).get(i));
                    count++;
                }
            }
        }
        return count==n;
    }
}