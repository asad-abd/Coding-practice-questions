//the small addition of maxWordLength decreases time from 7ms to 1ms!
import java.util.*;
class _139_WordBreak {
    //second time: gfg
    //since i,j are considered for states, at max s^2 states possible.
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
                j++;
            }
            if(hmap.containsKey(""+i+","+j)) return hmap.get(""+i+","+j);
        }
        return false;
    }

    //first time
    HashSet<String> hset;
    int maxWordLength = 0;

    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0)
            return true;

        int[] StringStartingAt = new int[s.length() + 1];

        StringStartingAt[s.length()] = 1;

        hset = new HashSet<>(wordDict);
        for (String w : hset) {
            maxWordLength = Math.max(maxWordLength, w.length());
        }
        return util(s, 0, StringStartingAt);
    }

    public boolean util(String s, int start, int[] StringStartingAt) {
        if (start >= s.length()) {
            return true;
        }
        if (StringStartingAt[start] != 0) {
            // string after this point can be made with the dictionary words (as calculated
            // from a previous function call)- no need to re-solve it.
            if (StringStartingAt[start] == 1)
                return true;
            else
                return false;
        }
        for (int end = start + 1; end <= s.length() && end - start <= maxWordLength; end++) {
            // find if the substring s(start,end) is present in the dictionary && whether
            // the substring s(end,n) can be made with the function.
            String word = s.substring(start, end);
            String leftString = s.substring(end);
            if (hset.contains(word) && util(s, end, StringStartingAt)) {
                StringStartingAt[start] = 1;
                return true;

            }

        }
        StringStartingAt[start] = -1;
        return false;
    }

}
