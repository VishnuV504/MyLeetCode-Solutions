class Solution {
    public boolean isValidSudoku(char[][] board) { 
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++)
        {
            int rowFreq[] =new int[10];
            for(int j=0;j<n;j++)
            {
                if(board[i][j]=='.') continue;
                if(rowFreq[(int)(board[i][j]-'0')]==1) return false;
                rowFreq[(int)(board[i][j]-'0')]=1;
            }
        }
        for(int i=0;i<m;i++)
        {
            int colFreq[]= new int[10];
            for(int j=0;j<n;j++)
            {
                if(board[j][i]=='.') continue;
                if(colFreq[(int)(board[j][i]-'0')]==1) return false;
                colFreq[(int)(board[j][i]-'0')]=1;
            }
        }
        int i=0;
        while(i<9)
        {
            int k=0;
            while(k<9)
            {
                int gridFreq[]= new int[10];
                for(int j=k;j<k+3;j++)
                {
                    for(int l=i;l<i+3;l++)
                    {
                        //System.out.println(j+" "+l);
                        if(board[j][l]=='.') continue;
                        if(gridFreq[(int)(board[j][l]-'0')]==1) return false;
                        gridFreq[(int)(board[j][l]-'0')]=1;
                    }
                }
                k=k+3;
            }
            i=i+3;
        }
        
        return true;
        
    }
}