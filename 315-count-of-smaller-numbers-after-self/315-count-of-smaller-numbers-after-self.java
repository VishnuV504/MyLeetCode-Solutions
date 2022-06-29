class Solution {
    ArrayList<Integer>li2= new ArrayList<>();
    public List<Integer> countSmaller(int[] nums) {
        int n=nums.length;
        List<Integer>li = new ArrayList<Integer>();
        li.add(0); li2.add(nums[n-1]);
        for(int i=n-2;i>=0;i--){
            int point=Ub(nums[i]-1);
            li.add(point);
            li2.add(point,nums[i]);
            
        }
        Collections.reverse(li);
        return li;
    }
    private int Ub(int k){
        int j=li2.size()-1; int ans=-1;
        int i=0;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(li2.get(mid)<=k){
                ans=mid;
                i=mid+1;
            }
            else
                j=mid-1;
        }
        if(ans==-1)return 0;
        return ans+1;
        
    }
}