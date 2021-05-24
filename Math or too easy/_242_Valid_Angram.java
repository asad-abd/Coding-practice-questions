class _242_Valid_Angram {
    public boolean isAnagram(String s, String t) {
        if(s.length()!=t.length())
            return false;
        HashMap<Character, Integer> h1=new HashMap<>();
        HashMap<Character, Integer> h2=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch1=s.charAt(i);
            char ch2=t.charAt(i);
            h1.put(ch1,h1.getOrDefault(ch1, 0)+1);
            h2.put(ch2,h2.getOrDefault(ch2, 0)+1);
        }
        return h1.equals(h2);
    }
}
