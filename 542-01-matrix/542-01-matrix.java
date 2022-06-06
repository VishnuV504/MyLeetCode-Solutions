class Solution {
    int[][] directions = {{-1,0},{1,0},{0,-1},{0,1}};
    public int[][] updateMatrix(int[][] mat) {
        int m= mat.length;
        int n= mat[0].length;
        int ans[][]= new int[m][n];
        //-1 mean unvisited
        for(int i=0;i<m;i++)
        Arrays.fill(ans[i],-1);
        solve(mat,ans);
        return ans;  
    }
    private void solve(int mat[][],int ans[][])
    {
        int m= mat.length;
        int n= mat[0].length;
        Queue<Pair<Integer,Integer>>q = new LinkedList<Pair<Integer,Integer>>();
        //add all zeros into q ans their co-ordinates
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==0)
                {
                    q.add(new Pair<>(i,j));
                    ans[i][j]=0;
                }
            }
        }
        int lvl=1;
        while(!q.isEmpty())
        {
            int size=q.size();
            while(size!=0)
            {
                int key=q.peek().getKey();
                int value=q.peek().getValue();
                q.remove();
                //push the neighbours
               for(int i=0;i<4;i++)
               {
                   int Xcor=key+directions[i][0];
                   int Ycor=value+directions[i][1];
                   if(Xcor>=0 &&Xcor<m &&Ycor>=0 &&Ycor<n&&ans[Xcor][Ycor]==-1)
                   {
                       ans[Xcor][Ycor]=lvl;
                       q.add(new Pair<>(Xcor,Ycor));
                   }
               }
                size--;
            }
            lvl++;
        }
    }
}