class Solution {
    public int minDeletions(String s) {
       int n=s.length(); int freq[]= new int[26];  int count=0;
        for(int i=0;i<n;i++)
            freq[(int)(s.charAt(i)-'a')]++;
        Arrays.sort(freq); HashMap<Integer,Integer>hs1 = new HashMap<>();
        for(int i=25;i>=0;i--){
            if(freq[i]==0)continue;
            int j;
            for(j=freq[i];j>=0;j--){
                if(!hs1.containsKey(j)){
                    hs1.put(j,1);
                    break;
                }
            }
            System.out.println(j);
            if(j>=0)
            count+=freq[i]-j;
            else
                count+=freq[i];
        }
        return count;
        
    }
}