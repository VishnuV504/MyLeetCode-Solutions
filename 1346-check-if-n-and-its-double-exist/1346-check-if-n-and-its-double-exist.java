class Solution {
    public boolean checkIfExist(int[] arr) {
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        for(int i=0;i<arr.length;i++)
        {
                if(hs1.containsKey(arr[i]*2))
                    return true;
                else if(arr[i]%2==0 && hs1.containsKey(arr[i]/2))
                    return true;
                else
                hs1.put(arr[i],1);
        }
        return false;
    }
}