class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character,Integer>hs1 = new HashMap<>();
        List<String>li = new ArrayList<>();
        for(int i=0;i<words2.length;i++)
        {
            HashMap<Character,Integer>hs3 = new HashMap<>();
            for(int j=0;j<words2[i].length();j++)
            {
                if(hs3.containsKey(words2[i].charAt(j)))
                    hs3.put(words2[i].charAt(j),hs3.get(words2[i].charAt(j))+1);
                else
                    hs3.put(words2[i].charAt(j),1);
            }
            for(Character key: hs3.keySet())
            {
                if(!hs1.containsKey(key))
                    hs1.put(key,hs3.get(key));
                else if(hs3.get(key)>hs1.get(key))
                    hs1.put(key,hs3.get(key));
            }
        }
        for(int i=0;i<words1.length;i++)
        {
            HashMap<Character,Integer>hs2 =new HashMap<>();
            for(int j=0;j<words1[i].length();j++)
            {
                if(hs2.containsKey(words1[i].charAt(j)))
                    hs2.put(words1[i].charAt(j),hs2.get(words1[i].charAt(j))+1);
                else
                    hs2.put(words1[i].charAt(j),1);      
            }
            boolean flag=false;
            for(Character key :hs1.keySet())
            {
                if(!hs2.containsKey(key))
                {
                    flag=true;
                    break;
                }
                else
                {
                    int a=hs1.get(key);
                    int b=hs2.get(key);
                    if(b<a)
                    {
                        flag=true;
                        break;
                    }
                }
            }
            //System.out.println(count);
            if(flag==false)
                li.add(words1[i]);
        }
        return li;
        
    }
}