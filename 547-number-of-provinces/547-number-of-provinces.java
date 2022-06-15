class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length; int count=0;
        boolean visited[]= new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(visited[i]==false)
            {
                count++;
                bfs(i,isConnected,visited);
                
            }
        }
        return count;
    }
    private void bfs(int k,int[][] arr,boolean visited[])
    {
        Queue<Integer>q = new LinkedList<>();
        q.add(k);
        visited[k]=true;
        while(!q.isEmpty())
        {
            int ele=q.remove();
            for(int i=0;i<arr.length;i++)
            {
                if(visited[i]==false&& arr[ele][i]==1)
                {
                    q.add(i);
                    visited[i]=true;
                }
            }
            
        }
        return;
    }
}