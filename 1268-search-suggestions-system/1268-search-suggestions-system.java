class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>>ans = new ArrayList<List<String>>();
        Arrays.sort(products); int index=0;int index2=products.length-1; int i=0;
        for(i=0;i<searchWord.length();i++)
        {
            List<String>li = new ArrayList<>();
            int count=0;
            int lb=lowerBound(index,products,searchWord,i,index2);
            if(lb==-1)break;
            int ub=upperBound(index,products,searchWord,i,index2);
            index=lb;
            index2=ub;
           //System.out.println(ub +"upper "+" "+lb);
            for(int j=lb;j<lb+3&&j<products.length&&j<=ub;j++)
            li.add(products[j]);
            ans.add(new ArrayList<>(li));
        }
        if(i<searchWord.length())
            for(int j=i;j<searchWord.length();j++)
                ans.add(new ArrayList<>());
        return ans;
        
    }
    private int lowerBound(int i,String products[],String searchWord,int j,int k)
    {
        int index=-1; char target=searchWord.charAt(j);
        while(i<=k)
        {
            int mid=i+(k-i)/2;
            if(j<products[mid].length())
            {
                char curr=products[mid].charAt(j);
                if(curr>=target)
                {
                    if(curr==target)
                    index=mid;
                    k=mid-1;
                }
                else 
                    i=mid+1;
            }
            else
                i=mid+1;
        //System.out.println(curr+" "+j+" "+index+" "+i+" "+k);
        }
        return index;
        
    }
    private int upperBound(int i,String products[],String searchWord,int j,int k)
    {
        int index=-1; char target=searchWord.charAt(j);
        while(i<=k)
        {
            int mid=i+(k-i)/2;
            if(j<products[mid].length())
            {
                char curr=products[mid].charAt(j);
                if(curr<=target)
                {
                    if(curr==target)
                    index=mid;
                    i=mid+1;
                }
                else
                    k=mid-1;
            }
            else i=mid+1;
            //System.out.println(curr+" "+j+" "+index+" "+i+" "+k);

        }
        return index;
    }
}