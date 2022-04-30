class Solution {
    List<String>li = new ArrayList<>();
    public List<String> findWords(char[][] board, String[] words) {
        int m=board.length;
        int n=board[0].length;
        for(int k=0;k<words.length;k++)
        {
            int length=words[k].length()-1;
            boolean flag= false;
            for(int i=0;i<m;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(solve(length,i,j,board,words[k],m,n)==true)
                    {
                        flag=true;
                        li.add(words[k]);
                        break;
                    }
                }
                if(flag==true) break;
            }    
        }
        return li;
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