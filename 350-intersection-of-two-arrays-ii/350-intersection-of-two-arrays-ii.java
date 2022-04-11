class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer,Integer>hs1 = new HashMap<Integer,Integer>();
        ArrayList<Integer>ans = new ArrayList<>();
        for(int i=0;i<nums1.length;i++)
        {
            if(hs1.containsKey(nums1[i]))
                hs1.put(nums1[i],hs1.get(nums1[i])+1);
            else
                hs1.put(nums1[i],1);
        }
        for(int j=0;j<nums2.length;j++)
        {
            if(hs1.containsKey(nums2[j]))
            {
                ans.add(nums2[j]);
                if(hs1.get(nums2[j])==1)
                    hs1.remove(nums2[j]);
                else
                    hs1.put(nums2[j],hs1.get(nums2[j])-1);
            }
        }
        int[] arr = new int[ans.size()];
        for(int k=0;k<arr.length;k++)
        {
            arr[k]=ans.get(k);
        }
        return arr;

        
    }
}