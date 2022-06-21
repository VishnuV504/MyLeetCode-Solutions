class Solution {
    public int minDeletions(String s) {
        //sort by char freq
        int n=s.length();
        int arr[]= new int[26];
        for(int i=0;i<n;i++)
            arr[(int)s.charAt(i)-97]++;
        Arrays.sort(arr); int min=0;
        HashMap<Integer,Boolean>hs1 = new HashMap<>();
        for(int i=0;i<26;i++)
        {
            if(arr[i]!=0){
                if(!hs1.containsKey(arr[i])) hs1.put(arr[i],true);
                else {
                    int j=arr[i];
                    for(j=arr[i];j>0;j--){
                        if(!hs1.containsKey(j)){
                            hs1.put(j,true);
                            break;
                        }
                    }
                    min+=arr[i]-j;
                }
            }
        }
        return min; 
    }
}