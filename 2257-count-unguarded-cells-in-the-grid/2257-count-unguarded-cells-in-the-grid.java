class Solution {
    int count;
    HashMap<String,Integer>g= new HashMap<>();
    HashMap<String,Integer>w = new HashMap<>();
    int visited[][];
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        count=walls.length+guards.length;
        visited=new int[m][n];
        //put into map
        for(int i=0;i<guards.length;i++)
        {
            String a=guards[i][0]+"-"+guards[i][1];
            g.put(a,1);
        }
        for(int i=0;i<walls.length;i++)
        {
            String a=walls[i][0]+"-"+walls[i][1];
            w.put(a,1);
        }
        for(int i=0;i<guards.length;i++)
        {
            up(guards[i][0],guards[i][1],m,n);
            //System.out.println(count);
            down(guards[i][0],guards[i][1],m,n);
            //System.out.println(count);
            left(guards[i][0],guards[i][1],m,n);
           // System.out.println(count);
            right(guards[i][0],guards[i][1],m,n);
           // System.out.println(count);
        }   
        return m*n-count;   
    }
    private void up(int row,int col,int m,int n)
    {
        for(int i=row-1;i>=0;i--)
        {
            String a=i+"-"+col;
            if(g.containsKey(a)||w.containsKey(a))
                return;
            if(visited[i][col]==0)
            {
                count++;
                visited[i][col]=1;   
            }
        }
        return ;
    }
    private void down(int row,int col,int m,int n)
    {
        for(int i=row+1;i<m;i++)
        {
            String a=i+"-"+col;
            if(g.containsKey(a)||w.containsKey(a))
                return;
            if(visited[i][col]==0)
            {
                count++;
                visited[i][col]=1;   
            }
        }
        return ;

    }
    private void left(int row,int col,int m,int n)
    {
        for(int i=col-1;i>=0;i--)
        {
            String a=row+"-"+i;
            if(g.containsKey(a)||w.containsKey(a))
                return;
            if(visited[row][i]==0)
            {
                count++;
                visited[row][i]=1;   
            }
        }
        return ;

    }
    private void right(int row,int col,int m,int n)
    {
        for(int i=col+1;i<n;i++)
        {
            String a=row+"-"+i;
            if(g.containsKey(a)||w.containsKey(a))
                return;
            if(visited[row][i]==0)
            {
                count++;
                visited[row][i]=1;   
            }
        }
        return ;

    }
}