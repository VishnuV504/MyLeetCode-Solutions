class Solution {
    public int minPartitions(String n) {
        int m=n.length(); int max=((int)n.charAt(0))-48;
        for(int i=0;i<m;i++)
            max=Math.max(((int)n.charAt(i))-48,max); 
        return max;
        
    }
}