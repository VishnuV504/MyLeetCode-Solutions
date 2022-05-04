class Solution {
    public int totalFruit(int[] fruits) {
                HashMap<Integer,Integer>hs1= new HashMap<>();
        int j=0; int maxLength=0; int n=fruits.length;
        int distinct=0;
        for(int i=0;i<n;i++)
        {
            while(!hs1.containsKey(fruits[i])&&distinct==2)
            {
                if(hs1.get(fruits[j])==1)
                {
                    hs1.remove(fruits[j]);
                    distinct--;
                }
                else
                    hs1.put(fruits[j],hs1.get(fruits[j])-1);
                j++;
            }
            if(hs1.containsKey(fruits[i]))
                hs1.put(fruits[i],hs1.get(fruits[i])+1);
            else
            {
                hs1.put(fruits[i],1);
                distinct++;
            }
            maxLength=Math.max(maxLength,i-j+1);
        }
        return maxLength;

        
    }
}