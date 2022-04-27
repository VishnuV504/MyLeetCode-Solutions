class Solution {
    public int maxCompatibilitySum(int[][] students, int[][] mentors) {
        int maxScore[]= new int[1];
        int mask=0;
        solve(0,students,mentors,0,mask,maxScore);
        return maxScore[0];   
    }
    private void solve(int curr,int students[][],int mentors[][],int sum,int mask,int maxScore[])
    {
        if(curr==students.length)
        {
            if(sum>maxScore[0])
                maxScore[0]=sum;
            return;
        }
        for(int i=0;i<students.length;i++)
        {
            if((mask&(1<<i))!=0) continue;
            int temp=sum; 
            for(int j=0;j<students[i].length;j++)
            {
                if(students[i][j]==mentors[curr][j])
                    sum++;
            }
            mask|=1<<i;
            solve(curr+1,students,mentors,sum,mask,maxScore);
            mask^=1<<i;
            sum=temp;
        }
    }
}