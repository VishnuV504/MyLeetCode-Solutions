class Solution {
    public int calPoints(String[] ops) {
        List<Integer>li = new ArrayList<>();
        for(int i=0;i<ops.length;i++)
        {
            if(ops[i].equals("D"))
            {
                int num=li.get(li.size()-1);
                li.add(num*2);
            }
            else if(ops[i].equals("C"))
                li.remove(li.size()-1);
            else if(ops[i].equals("+"))
            {
                int num1=li.get(li.size()-1)+li.get(li.size()-2);
                li.add(num1);
            }
            else
            {
                int num=Integer.parseInt(ops[i]);
                li.add(num);
            }
                
        }
        int sum=0;
        for(int i=0;i<li.size();i++)
            sum+=li.get(i);
        return sum;
        
        
    }
}