class Solution {
    List<List<String>>ans = new ArrayList<List<String>>();
    public List<List<String>> solveNQueens(int n) {
         char board[][]= new char[n][n];
        for(int i=0;i<n;i++) Arrays.fill(board[i],'.');
        int colMask=0;
        solve(0,board,n,colMask);
        
        return ans;
    }
    private void solve(int row,char grid[][],int n,int colMask)
    {
        if(row==n)
        {
            List<String>li = new ArrayList<>();
            for(int i=0;i<n;i++)
            {
                String s="";
                for(int j=0;j<n;j++)
                    s+=grid[i][j];
                li.add(s);
            }
            ans.add(new ArrayList<>(li));
        }
        for(int i=0;i<n;i++)
        {
            if((colMask&(1<<i))!=0) continue;
            if(isValid(grid,row,i,n)==true)
            {
                grid[row][i]='Q';
                colMask|=1<<i;
                solve(row+1,grid,n,colMask);
                colMask^=1<<i;
                grid[row][i]='.';
            }
        }
    }
    private boolean isValid(char grid[][],int row,int col,int n)// check diagnol
    {
        int a=col+1;
        for(int i=row-1;i>=0;i--)
        {
            if(a<n && grid[i][a]=='Q') return false;
            a++;
        }
        a=col-1;
        for(int i=row-1;i>=0;i--)
        {
            if(a>=0&&grid[i][a]=='Q') return false;
            a--;
        }
        return true;
    }
 }