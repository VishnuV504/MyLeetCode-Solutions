class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==1||grid[n-1][n-1]==1) return -1;
        int visited[][]= new int[n][n];
        for(int i=0;i<n;i++)
        Arrays.fill(visited[i],-1);
        return solve(grid,visited,n);
        
    }
    private int solve(int grid[][],int visited[][],int n)
    {
        int[][] directions = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{1,-1},{-1,1}};
        Queue<Pair<Integer,Integer>>q= new LinkedList<>();
        q.add(new Pair<>(0,0));
        int lvl=1;
        while(!q.isEmpty())   
        {
            int size=q.size();
            //System.out.println(size);
            while(size!=0)
            {
                int key=q.peek().getKey();
                int value=q.peek().getValue();
                q.remove();
                if(key==n-1 && value==n-1) return lvl;
                for(int i=0;i<8;i++)
                {
                    int Xcor=key+directions[i][0];
                   int Ycor=value+directions[i][1];
                   if(Xcor>=0 &&Xcor<n &&Ycor>=0 &&Ycor<n&&visited[Xcor][Ycor]==-1&&grid[Xcor][Ycor]==0)
                   {
                        q.add(new Pair<>(Xcor,Ycor));
                        visited[Xcor][Ycor]=1;
                   }
                }
                size--;
            }
            lvl++;
        }
        return -1; 
    }
}