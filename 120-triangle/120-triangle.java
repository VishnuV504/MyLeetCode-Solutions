class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<List<Integer>>dp = new ArrayList<>();
        List<Integer>li = new ArrayList<>();int OverAllMin=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(0).size();i++)
        li.add(triangle.get(0).get(i));
        dp.add(li); int m=triangle.size();
        for(int i=1;i<m;i++)
        {
            List<Integer>li2 = new ArrayList<>();
            for(int j=0;j<triangle.get(i).size();j++)
            {
                int up=Integer.MAX_VALUE;
                int upL=Integer.MAX_VALUE;
                if(dp.get(i-1).size()>j)
                    up=dp.get(i-1).get(j);
                if(j>=1&&dp.get(i-1).size()>j-1)
                    upL=dp.get(i-1).get(j-1);
                int addToList=triangle.get(i).get(j)+Math.min(up,upL);
                li2.add(addToList);  
            }
            dp.add(li2);
        }
        int n=dp.size()-1;
        for(int j=0;j<dp.get(n).size();j++)
            OverAllMin=Math.min(dp.get(n).get(j),OverAllMin); 
        return OverAllMin;
    }
}