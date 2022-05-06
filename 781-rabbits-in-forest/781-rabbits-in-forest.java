class Solution {
    public int numRabbits(int[] answers) {
        int count=0;
        HashMap<Integer,Integer>hs1 = new HashMap<>();
        int n= answers.length;
        for(int i=0;i<n;i++)
        {
            int rab=answers[i];
            if(hs1.containsKey(rab))
            {
                if(hs1.get(rab)==rab+1)
                {
                    count+=rab+1;
                    hs1.put(rab,1);
                }
                else 
                    hs1.put(rab,hs1.get(rab)+1);
            }
            else
                hs1.put(rab,1);
        }
        for(Integer key :hs1.keySet())
            count+=key+1;
        return count;
        
    }
    //at max one  group  should contain val+1 rabbits whenever a group contains val+1 rabbits add to count and start again
}