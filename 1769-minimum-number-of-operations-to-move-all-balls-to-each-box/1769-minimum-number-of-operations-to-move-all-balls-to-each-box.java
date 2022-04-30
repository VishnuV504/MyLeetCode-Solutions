class Solution {
    public int[] minOperations(String boxes) {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int n=boxes.length();
        for(int i=0;i<n;i++)
        if(boxes.charAt(i)=='1')hs1.put(i,1);
        int arr[] = new int[n];
        for(int i=0;i<n;i++)
        {
            int op=0;
            for(Integer key :hs1.keySet())
                op+=Math.abs(key-i);
            arr[i]=op;
        }
        return arr;
        
    }
}