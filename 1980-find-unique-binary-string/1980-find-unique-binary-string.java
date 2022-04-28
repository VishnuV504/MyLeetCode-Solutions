class Solution {
    String ans[] = new String[1];
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder str = new StringBuilder("a");
        HashMap<String,Integer>hs1 = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
            hs1.put(nums[i],1);
        ans[0]="afkjlkjalkjlgadfagg";
        solve(n,str,hs1);  
        return ans[0];
    }
    private void solve(int n, StringBuilder str,HashMap<String,Integer>hs1)
    {
        if(ans[0].length()==n) return ;
        if(str.length()>n)
        {
            String a=(str.substring(1,str.length())).toString();
            //System.out.println(a);
            if(!hs1.containsKey(a))
                ans[0]=a;
            return;
        }
        str.append('0');
        solve(n,str,hs1);
        str.deleteCharAt(str.length()-1);
        str.append('1');
        solve(n,str,hs1);
        str.deleteCharAt(str.length()-1);
    }
}