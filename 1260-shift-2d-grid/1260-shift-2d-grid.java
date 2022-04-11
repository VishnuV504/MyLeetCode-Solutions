class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        
        List<List<Integer>>li = new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            List<Integer>r = new ArrayList<>();
            for(int j=0;j<grid[i].length;j++)
                r.add(0);
            li.add(r);
                
        }
        k%=grid.length*grid[0].length;
        for(int i=0;i<grid.length;i++)
        {
            for(int j=0;j<grid[i].length;j++)
            {
                int row=(i*grid[i].length+j+k)/(grid[i].length)%grid.length;
                int col=(j+k)%grid[i].length;
                System.out.println(row+" "+col);
                li.get(row).set(col,grid[i][j]);
            }
        }
        return li;
    }
}