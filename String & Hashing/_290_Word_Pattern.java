class _290_Word_Pattern {
    //same mapping concept as _205
    public boolean wordPattern(String pattern, String s) {
        //HashMap<Character, Integer> not used due to some JVM caching issues for num>128
        HashMap<Character, String> patt=new HashMap<>();
        HashMap<String, String> stt=new HashMap<>();
        //HashMap<String> str=new HashMap<>();
        
        String[] sarr=s.split(" ");
        if(pattern.length()!=sarr.length)
            return false;
        for(int i=0;i<sarr.length;i++){
            char c=pattern.charAt(i);
            String s1=sarr[i];
            
            if(patt.containsKey(c) && !stt.containsKey(s1) || !patt.containsKey(c) && stt.containsKey(s1))
                return false;
            if(patt.containsKey(c)==false && stt.containsKey(s1)==false){
                patt.put(c,""+i);
                stt.put(s1,""+i);
                continue;
            }
            //System.out.println(c+" , "+s1);   
            if(patt.containsKey(c) && stt.containsKey(s1)){
                
                if(!patt.get(c).equals(stt.get(s1))){
                    //System.out.println(patt.get(c)+" , "+stt.get(s1));   
                    //System.out.println("HERE");
                    return false;}
                //else same, update
                patt.put(c,""+i);
                stt.put(s1,""+i);
            }
            
        }
        //System.out.println(Arrays.toString(sarr));
        return true;
    }
}
