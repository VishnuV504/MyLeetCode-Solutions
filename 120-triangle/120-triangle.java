class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer>dp = new ArrayList<>();
        List<Integer>li = new ArrayList<>();int OverAllMin=Integer.MAX_VALUE;
        for(int i=0;i<triangle.get(0).size();i++)
        dp.add(triangle.get(0).get(i));
        int m=triangle.size();
        for(int i=1;i<m;i++)
        {
            List<Integer>li2 = new ArrayList<>(dp);
            dp.clear();
            for(int j=0;j<triangle.get(i).size();j++)
            {
                int up=Integer.MAX_VALUE;
                int upL=Integer.MAX_VALUE;
                if(li2.size()>j)
                    up=li2.get(j);
                if(j>=1&&li2.size()>j-1)
                    upL=li2.get(j-1);
                int addToList=triangle.get(i).get(j)+Math.min(up,upL);
                dp.add(addToList);  
            }
            
        }
        for(int j=0;j<dp.size();j++)
            OverAllMin=Math.min(dp.get(j),OverAllMin); 
        return OverAllMin;
    }
}