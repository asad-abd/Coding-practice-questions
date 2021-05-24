class _205_Isomorphic_Strings {
    public boolean isIsomorphic(String s, String t) {
        //at an instant we see both s(i) and t(i)
        //these chars should ideally be mapped to each other.
        //And if this is a correct solution then the last matched indices of these chars must be same.
        //so, if we have s(i) and t(i). maps[s(i)]==mapt[t(i)]
        //else false
        int maps[]=new int[130];
        int mapt[]=new int[130];
        int n=s.length();
        char c1,c2;
        for(int i=0;i<n;i++){
            c1=s.charAt(i);
            c2=t.charAt(i);
            if(maps[c1]!=mapt[c2])
                return false;
            maps[c1]=i+1;
            mapt[c2]=i+1;
            //System.out.println(maps[(int)'a'] +" , "+mapt[(int)'a']+"\n"+maps[(int)'b'] +" , "+mapt[(int)'b']+"\n");
        }
        
        return true;
    }
}
