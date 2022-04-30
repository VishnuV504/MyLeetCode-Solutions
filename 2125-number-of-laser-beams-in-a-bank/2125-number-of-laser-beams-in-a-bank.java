class Solution {
    public int numberOfBeams(String[] bank) {
        int m=bank.length;
        int n=bank[0].length();
        int total=0;
        int countOnesIth=0;
        int i=0;
        //countOnes in ith row
        while(countOnesIth==0 &&i<m)
        {
            for(int j=0;j<n;j++) if(bank[i].charAt(j)=='1') countOnesIth++;
            if(countOnesIth==0) i++;
        }
        for(int l=i;l<m-1;l++)
        {
            int countJth=0;
            l++;
            while(countJth==0 && l<m)
            {
                for(int k=0;k<n;k++) if(bank[l].charAt(k)=='1')countJth++;
                if(countJth>=1) break;
                else l++;
            }
            l--;
            total+=countOnesIth*countJth;
            countOnesIth=countJth;
        }
        return total;
    }
}