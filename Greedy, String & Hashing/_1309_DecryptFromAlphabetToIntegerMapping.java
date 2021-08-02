class _1309_DecryptFromAlphabetToIntegerMapping {
    public String freqAlphabets(String s) {
        HashMap<String,String> hmap=new HashMap<>();
        int c='a';
        for(int i=1;i<=26;i++){
            if(i<=9) hmap.put((""+i),(""+(char)c));
            else hmap.put((""+i+"#"),(""+(char)c));
            c++;
        }
        int j=0,n=s.length();
        String ans="";
        while(j<n){
            if(j<=n-3 && hmap.containsKey(s.substring(j,j+3)) ){
                ans+=hmap.get( s.substring(j,j+3) );
                j+=3;
            }
            else if(j<=n-2 && hmap.containsKey(s.substring(j,j+2)) ){
                ans+=hmap.get( s.substring(j,j+2) );
                j+=2;
            }
            else if(j<=n-1 && hmap.containsKey(s.substring(j,j+1)) ){
                ans+=hmap.get( s.substring(j,j+1) );
                j+=1;
            }
        }
        if(j<n)
            System.out.println("error");
        return ans;
    }
}
