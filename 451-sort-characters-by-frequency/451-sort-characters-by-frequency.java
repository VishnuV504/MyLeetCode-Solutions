class Solution {
    public String frequencySort(String s) {
        HashMap<Character,Integer>hs1 = new HashMap<>();
        int n=s.length();
        for(int i=0;i<n;i++)
        {
            if(hs1.containsKey(s.charAt(i)))
                hs1.put(s.charAt(i),hs1.get(s.charAt(i))+1);
            else
                hs1.put(s.charAt(i),1);
        }
PriorityQueue<Pair<Integer,Character>>maxHeap = new PriorityQueue<Pair<Integer,Character>>(Comparator.comparing(Pair::getKey));
        for(Character Key :hs1.keySet())
            maxHeap.add(new Pair<>(hs1.get(Key),Key));
        StringBuilder ans=new StringBuilder();
        while(maxHeap.size()!=0)
        {
            char a=maxHeap.peek().getValue();
            int repeat=maxHeap.peek().getKey();
            while(repeat!=0)
            {
                ans.append(a);
                repeat--;
            }
            maxHeap.remove();
        }
        ans.reverse();
        return ans.toString();  
    }
}