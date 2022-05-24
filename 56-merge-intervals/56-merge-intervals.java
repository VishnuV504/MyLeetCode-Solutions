class Solution {
    public int[][] merge(int[][] intervals) {
        List<Integer>li = new ArrayList<>();
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        int n=intervals.length;
        int first=intervals[0][0]; int second=intervals[0][1];
        for(int i=1;i<n;i++)
        {
            if(intervals[i][0]<=second)
                second=Math.max(second,intervals[i][1]);
            else
            {
                li.add(first); li.add(second);
                first=intervals[i][0];
                second=intervals[i][1];
            }
        }
        li.add(first); li.add(second);
        int arr[][]= new int[li.size()/2][2];
        int k=0;
        for(int i=0;i<li.size();i=i+2)
        {
            arr[k][0]=li.get(i);
            arr[k][1]=li.get(i+1);
            k++;
        }
        return arr;

                
        
    }
}