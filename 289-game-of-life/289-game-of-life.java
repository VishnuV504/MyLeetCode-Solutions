class Solution {
    public void gameOfLife(int[][] board) {
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                int count=0;
                if(j+1<n&& board[i][j+1]>=1)
                    count++;
                if(j-1>=0&&board[i][j-1]>=1)
                    count++;
                if(i+1<m&& board[i+1][j]>=1)
                    count++;
                if(i-1>=0 &&board[i-1][j]>=1)
                    count++;
                if(i+1<m &&j+1<n&&board[i+1][j+1]>=1)
                    count++;
                if(i+1<m &&j-1>=0&&board[i+1][j-1]>=1)
                    count++;
                if(i-1>=0 &&j-1>=0&&board[i-1][j-1]>=1)
                    count++;
                if(i-1>=0 && j+1<n&&board[i-1][j+1]>=1)
                    count++;
                //System.out.println(count);
                if(board[i][j]==1 && count>=1)
                    board[i][j]=count;
                else if(count==3)
                    board[i][j]=-1;
                    
            }
        }
        
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]<0)
                    board[i][j]=1;
                else if(board[i][j]==2||board[i][j]==3)
                    board[i][j]=1;
                else
                    board[i][j]=0;
            }
        }
        
    }
}