class Solution {
    public String arrangeWords(String text) {
        String arr[]=text.split(" ");
         Arrays.sort(arr, (a, b)->Integer.compare(a.length(), b.length()));
        String ans="";
        for(int i=0;i<arr.length;i++){
            if(i==0){
                ans+=Character.toUpperCase(arr[0].charAt(0));
                for(int j=1;j<arr[0].length();j++)
                    ans+=arr[0].charAt(j);
            }
            else{
                if(arr[i].charAt(0)>=65 &&arr[i].charAt(0)<=90 ){
                    ans+=Character.toLowerCase(arr[i].charAt(0));
                    for(int j=1;j<arr[i].length();j++)
                        ans+=arr[i].charAt(j);
                }
                else
                    ans+=arr[i];
            }
            if(i!=arr.length-1)
            ans+=" ";
        }
        return ans;
        
    }
}