// aacaba
// 1 1 2 2 3 3  // prefix sum
// a-1
// a-2
// c-1
// a-3
// b-1
// a-4
// decrease count from map 
// if count is zer0 right side prefixsum-1
class Solution {
    public int numSplits(String s) {
        int prefixSum[] = new int[s.length()];
        HashMap<Character,Integer>hs1 = new HashMap<>();
        prefixSum[0]=1;
        hs1.put(s.charAt(0),1);
        for(int i=1;i<s.length();i++)
        {
            if(hs1.containsKey(s.charAt(i)))
            {
                hs1.put(s.charAt(i),hs1.get(s.charAt(i))+1);
                prefixSum[i]=prefixSum[i-1];
            }
            else
            {
                hs1.put(s.charAt(i),1);
                prefixSum[i]=prefixSum[i-1]+1;
            }
        }
        // for(int i=0;i<s.length();i++)
        //     System.out.println(prefixSum[i]);
        int count=0; int leftside=0;
        for(int i=0;i<s.length();i++)
        {
            if(hs1.get(s.charAt(i))==1)
            {
                leftside++;
                if(prefixSum[i]==prefixSum[s.length()-1]-leftside)
                    count++;
            }
            else
            {
                hs1.put(s.charAt(i),hs1.get(s.charAt(i))-1);
                if(prefixSum[i]==prefixSum[s.length()-1]-leftside)
                    count++;
                
            }
                
        }
        return count;
        
    }
}