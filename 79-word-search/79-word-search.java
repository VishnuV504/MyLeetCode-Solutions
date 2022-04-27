class Solution {
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int length=word.length()-1;
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(solve(length,i,j,board,word,m,n)==true) return true;
            }
        }
        return false;   
    }
    private boolean solve(int curr,int currRow,int currCol,char[][]board,String word,int m,int n)
    {
        if(curr==-1) return true;
        if(currRow<0 ||currCol<0||currRow>=m||currCol>=n||board[currRow][currCol]!=word.charAt(curr)||board[currRow][currCol]=='@') return false;
            char temp=board[currRow][currCol];
            board[currRow][currCol]='@';
            boolean left=solve(curr-1,currRow,currCol-1,board,word,m,n);
            boolean right=solve(curr-1,currRow,currCol+1,board,word,m,n);
            boolean top=solve(curr-1,currRow-1,currCol,board,word,m,n);
            boolean down=solve(curr-1,currRow+1,currCol,board,word,m,n);
            board[currRow][currCol]=temp;
            return left||right||top||down;
    }
    
}