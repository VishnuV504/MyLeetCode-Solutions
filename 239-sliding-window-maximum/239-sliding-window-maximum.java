class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new LinkedList<>(); int n=nums.length;
        int j=0; int ans[]=new int[n-k+1]; int l=0;
        for(int i=0;i<n;i++){
            if(dq.isEmpty()||nums[i]<nums[dq.getLast()])
                dq.addLast(i);
            else{
                while(!dq.isEmpty()&&nums[dq.getLast()]<=nums[i]){
                    dq.removeLast();
                }
                dq.add(i);
            }
            if(i-j+1==k){
                ans[l++]=nums[dq.getFirst()];
                if(dq.getFirst()==j)
                    dq.removeFirst();
                j++;
            }
        }
        return ans;

        
    }
}