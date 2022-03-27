class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] weakest= new int[mat.length];
        int[]  row = new int[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            int countOnes=0;
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                    countOnes++;
            }
            weakest[i]=countOnes;
            row[i]=countOnes;
        }
        Arrays.sort(weakest);//1 1 1 4
        int result[] = new int[k]; // 1 4 1 1
        int l=0; int flag=0; int visited[] = new int[mat.length];
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat.length;j++)
            {
                if(row[j]==weakest[i] && visited[j]!=1)
                {
                    if(l==k)
                    {
                        flag=1;
                        break;
                    }
                    result[l++]=j;
                    visited[j]=1;
                }
            }
            if(flag==1)
                break;
        }
        return result;
    }
}