class _13_Integer_to_Roman {
    public int romanToInt(String s) {
        HashMap<String,Integer> hmap=new HashMap<>();
        hmap.put("I",1); hmap.put("IV",4); hmap.put("V",5); hmap.put("IX",9); hmap.put("X",10); 
        hmap.put("XL",40); hmap.put("L",50); hmap.put("XC",90); hmap.put("C",100); 
        hmap.put("CD",400); hmap.put("D",500); hmap.put("CM",900); hmap.put("M",1000);
        int ans=0;
        int n=s.length();
        for(int i=0;i<n;i++){
            String temp;
            if(i+1<n)
                temp = ""+ s.charAt(i) + s.charAt(i+1);
            else
                temp = ""+ s.charAt(i);
            if(hmap.containsKey(temp)){
                ans+=hmap.get(temp);
                i++;
            }
            else{
                temp = ""+ s.charAt(i);
                ans+=hmap.get(temp);
            }
        }
        return ans;
    }
}
