class Solution {
    List<List<Integer>>ans = new ArrayList<List<Integer>>();
    HashMap<String,Integer>queen = new HashMap<>();
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        for(int i=0;i<queens.length;i++)
        {
            String a=queens[i][0]+"-"+queens[i][1];
            queen.put(a,1);
        }
        Diagnols(king[0],king[1]);
        Rows(king[0],king[1]);
        return ans;
    }
    private void Diagnols(int row,int col)// check diagnol
    {
        int a=col+1;
        List<Integer>li = new ArrayList<>();
        for(int i=row-1;i>=0;i--) //45
        {
            String check=i+"-"+a;
            if(a<8 &&queen.containsKey(check))
            {
                li.add(i);
                li.add(a);
                break;
            }
            a++;
        }
        if(li.size()>0)
        {ans.add(new ArrayList<>(li));  li.clear();}
        
        
        a=col-1;
        for(int i=row-1;i>=0;i--) //315
        {
            String check=i+"-"+a;
            if(a>=0&&queen.containsKey(check))
            {
                li.add(i);
                li.add(a);
                break;
            }
            a--;
        }
        if(li.size()>0) {ans.add(new ArrayList<>(li));  li.clear();}
        //90
        a=col+1;
        for(int i=row+1;i<8;i++) //135
        {
            String check=i+"-"+a;
            if(a<8&&queen.containsKey(check))
            {
                li.add(i);
                li.add(a);
                break;
            }
            a++;
        }
        if(li.size()>0) {ans.add(new ArrayList<>(li));  li.clear();}
        
        a=col-1;
        for(int i=row+1;i<8;i++) //225
        {
            String check=i+"-"+a;
            if(a>=0&&queen.containsKey(check))
            {
                li.add(i);
                li.add(a);
                break;
            }
            a--;
        }
        if(li.size()>0) {ans.add(new ArrayList<>(li));  li.clear();}
    }
    private void Rows(int row,int col)
    {
        //up 
        List<Integer>li = new ArrayList<>();
        for(int i=row+1;i<8;i++)
        {
            String check=i+"-"+col;
            if(queen.containsKey(check))
            {
                li.add(i);
                li.add(col);
                break;
            }
        }
        if(li.size()>0) {ans.add(new ArrayList<>(li));  li.clear();}
        
        //down
        for(int i=row-1;i>=0;i--)
        {
            String check=i+"-"+col;
            if(queen.containsKey(check))
            {
                li.add(i);
                li.add(col);
                break;
            }
        }
        if(li.size()>0) {ans.add(new ArrayList<>(li));  li.clear();}
        //right
        for(int i=col+1;i<8;i++)
        {
            String check=row+"-"+i;
            if(queen.containsKey(check))
            {
                li.add(row);
                li.add(i);
                break;
            }
        }
        if(li.size()>0) {ans.add(new ArrayList<>(li));  li.clear();}
        //left
        for(int i=col-1;i>=0;i--)
        {
            String check=row+"-"+i;
            if(queen.containsKey(check))
            {
                li.add(row);
                li.add(i);
                break;
            }
        }
        if(li.size()>0) {ans.add(new ArrayList<>(li));  li.clear();}
        
        
    }

}