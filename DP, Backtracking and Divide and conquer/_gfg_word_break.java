//R1 Aug done
public class _gfg_word_break {
    //new- review Aug - simple mcm
    HashSet<String> hset;
    int n;
    int[][] t; 
    public boolean wb(String s, int i, int j){
        if(i > j) return true;

        if(t[i][j] != 0) return t[i][j] == 1? true: false;
        
        if(hset.contains(s.substring(i, j + 1))) return true;//imp
        
        for(int k = i + 1; k <= j; k ++){
            if(hset.contains(s.substring(i, k))){
                //check if (k+1, j) is empty or present
                if(wb(s, k, j)){
                    t[i][j] = 1;
                    return true;
                }
            }
        }
        t[i][j] = -1;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        hset = new HashSet<>(wordDict);
        n=s.length();
        t = new int [n + 1][n + 1];
        return wb(s, 0, n - 1);
    }

    //--- past code - couldn't understand in review
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
