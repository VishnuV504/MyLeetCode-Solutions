class Solution {
    public int countSubstrings(String s, String t) {
        HashMap<Integer,ArrayList<String>>hs1 = new HashMap<>();
        int m=s.length(); int n=t.length();
        for(int i=0;i<n;i++){
            int len=0; String check="";
            for(int j=i;j<n;j++){
                len++; check+=t.charAt(j);
                if(hs1.containsKey(len)){
                    ArrayList<String>li=new ArrayList<>(hs1.get(len));
                    li.add(check);
                    hs1.put(len,li);
                }
                else{
                    ArrayList<String>li = new ArrayList<>();
                    li.add(check);
                    hs1.put(len,li);
                }
            }
        }
        
        HashMap<Integer,ArrayList<String>>hs2 = new HashMap<>();
        for(int i=0;i<m;i++){
            int len2=0; String check2="";
            for(int j=i;j<m;j++){
                len2++; check2+=s.charAt(j);
                if(hs2.containsKey(len2)){
                    ArrayList<String>li2=new ArrayList<>(hs2.get(len2));
                    li2.add(check2);
                    hs2.put(len2,li2);
                }
                else{
                    ArrayList<String>li2 = new ArrayList<>();
                    li2.add(check2);
                    hs2.put(len2,li2);
                }
            }
        }
        
        int ans=0;
        for(Integer Key:hs1.keySet()){
            if(hs2.containsKey(Key)){
                ArrayList<String>li3= new ArrayList<>(hs2.get(Key));
                ArrayList<String>li4= new ArrayList<>(hs1.get(Key));
                for(int i=0;i<li3.size();i++){
                    for(int j=0;j<li4.size();j++){
                        if(isOk(li3.get(i),li4.get(j)))
                            ans++;
                    }
                }
                
            }
        }
        return ans;  
    }
    private boolean isOk(String s,String t){
        int k=1;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==t.charAt(i))continue;
            else if(k==1) k=0;
            else
                return false;
        }
        if(k==0)
        return true;
        return false;
    }
}