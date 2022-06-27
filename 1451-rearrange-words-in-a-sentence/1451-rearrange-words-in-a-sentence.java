class Solution {
    public String arrangeWords(String text) {
        String arr[]=text.toLowerCase().split(" ");
        return solve(arr);
        
    }
    public String  solve(String arr[]){
        HashMap<Integer,ArrayList<String>>hs1 = new HashMap<>();
        int min=Integer.MAX_VALUE; int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            int len=arr[i].length();
            if(hs1.containsKey(len)){
                ArrayList<String>li = new ArrayList<>(hs1.get(len));
                li.add(arr[i]);
                hs1.put(len,li); 
            }
            else{
                ArrayList<String>li = new ArrayList<>();
                li.add(arr[i]);
                hs1.put(len,li);
            }
            min=Math.min(min,len);
            max=Math.max(max,len);
        }
        String ans="";
        for(int i=min;i<=max;i++){
            if(hs1.containsKey(i)){
                for(int j=0;j<hs1.get(i).size();j++){
                    ans+=hs1.get(i).get(j);
                    if(i==max && j+1==hs1.get(max).size()) continue;
                    ans+=" ";
                }
            }
        }
        String ans2=Character.toUpperCase(ans.charAt(0))+ans.substring(1);
        return ans2;
    }
}