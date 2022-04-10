class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++)
        {
            int j=0; int k=grid[i].length-1;
            int lowerBound=-1;
            while(j<=k)
            {
                int mid=j+(k-j)/2;
                if(grid[i][mid]<0)
                {
                    lowerBound=mid;
                    k=mid-1;;
                }
                else 
                    j=mid+1;
            }
            if(lowerBound!=-1)
            count+=grid[i].length-lowerBound;
        }
        return count;
        
    }
}