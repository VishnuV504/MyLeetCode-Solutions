class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        ArrayList<Integer>li2 = new ArrayList<>();
        li2.add(1);
        ans.add(li2);
        for(int i=1;i<numRows;i++){
            ArrayList<Integer>li = new ArrayList<>();
            for(int j=0;j<=i;j++){
                if(j==0)
                    li.add(ans.get(i-1).get(0));
                else if(j==i)
                    li.add(ans.get(i-1).get(j-1));
                else
                    li.add(ans.get(i-1).get(j-1)+ans.get(i-1).get(j));
            }
            ans.add(li);
        }
        return ans;
    }
}