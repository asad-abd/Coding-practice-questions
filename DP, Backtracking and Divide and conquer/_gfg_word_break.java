public class _gfg_word_break {
    HashSet<String> hset;
    HashMap<String, Boolean> hmap = new HashMap<>();
    int n;
    public  int wordBreak(String s, ArrayList<String> wordDict )
    {
        hset = new HashSet<>(wordDict);
        n=s.length();
        return wb(s, 0,1)==false?0:1;
        
    }
    
    public boolean wb(String s, int i, int j){
        if(i==n) return true;
        if(j>n && i<n) return false;
        if(hmap.containsKey(""+i+","+j)) return hmap.get(""+i+","+j);
        while(j<=n){
            //System.out.println(i + " , "+ j);
            if(hset.contains(s.substring(i,j))){
                hmap.put(""+i+","+j, wb(s,i,j+1) | wb(s,j,j+1));
                return hmap.get(""+i+","+j);
                
            }
            else{
                hmap.put(""+i+","+j, false);
                j++;
                
            }
            if(hmap.containsKey(""+i+","+j)) return hmap.get(""+i+","+j);
            
        }
        return false;
    }
}
