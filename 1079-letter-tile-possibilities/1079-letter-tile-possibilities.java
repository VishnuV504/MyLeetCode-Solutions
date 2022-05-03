class Solution {
    public int numTilePossibilities(String s) {
        int count[] = new int[1];
        int mask=0; StringBuilder sb=new StringBuilder();
        char arr[]= s.toCharArray();
        Arrays.sort(arr);
        String tiles = new String(arr);
        solve(tiles,count,mask,sb); 
        return count[0];
    }
    private void solve(String tiles,int count[],int mask,StringBuilder sb)
    {
        if(sb.length()>tiles.length()) return;
        if(sb.length()>0)
        {
            count[0]++;
            //System.out.println(sb);
        }
        for(int j=0;j<tiles.length();j++)
        {
                if((mask&1<<j)!=0||j>0 && tiles.charAt(j)==tiles.charAt(j-1)&& !((mask&1<<j-1)!=0)) continue;
                mask|=1<<j;
                sb.append(tiles.charAt(j));
                solve(tiles,count,mask,sb);
                sb.deleteCharAt(sb.length()-1);
                mask^=1<<j;
        }
    }
}