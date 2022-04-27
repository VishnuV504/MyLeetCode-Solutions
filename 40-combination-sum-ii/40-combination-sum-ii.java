class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans = new ArrayList<List<Integer>>();
        List<Integer>res = new ArrayList<>();
        solve(0,candidates,target,res,ans);
        return ans;
        
    }
    private void solve(int curr,int arr[],int k,List<Integer>res,List<List<Integer>>ans)
    {
        if(k==0)
            ans.add(new ArrayList<>(res));
        if(curr>=arr.length)return;
        for(int i=curr;i<arr.length;i++)
        {
            if(i>0 && arr[i]==arr[i-1] || arr[i]==-1 ||k<arr[i]) continue;
                int temp=arr[i];
                res.add(temp);
                arr[i]=-1; // visited
                solve(i+1,arr,k-temp,res,ans);  // here solve i+1 because if a pick a element at some index next i should start with i+1 index only inorder to eliminate duplicate combinations
                res.remove(res.size()-1);
                arr[i]=temp;
                
        }
    }
}