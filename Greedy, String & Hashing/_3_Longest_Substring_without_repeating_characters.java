//R1 Aug done
public class _3_Longest_Substring_without_repeating_characters {
    //R1 Aug
    public int lengthOfLongestSubstring(String S) {
        int ans = 0;
        int i = 0, j = 0;
        char s[] = S.toCharArray();
        int n = s.length;
        HashSet<Character> hset = new HashSet<>();
        while(j < n){
            //add in the hashset if not already present
            //else, keep removing from hset till s[j] can be put
            while(i <= j && hset.contains(s[j])){
                hset.remove(s[i]);
                i ++;
            }
            if(!hset.contains(s[j])){
                hset.add(s[j]);
                ans = Math.max(ans, j - i + 1);
            }
            j ++;
        }
        return ans;
    }

    //first attempt: 2 pointer approach using hmap.
    //SMD1: temp = hmap.get(c[j]); //without this we get null pointer exception!! because after removing that num we are accessing it in the loop.
    //SMD2: forgot to do j++ once again at the end of the loop.
    public int lengthOfLongestSubstringOld(String s) {
        HashMap<Character, Integer> hmap = new HashMap<>();
        int i = 0, j = 0, len = 0;
        char c[] = s.toCharArray();
        int loopNum = 1;
        while(i < c.length && j < c.length){
            while( j < c.length && !hmap.containsKey(c[j]) ){
                hmap.put(c[j], j);
                j ++;
                len = Math.max(len, j - i);
            }
            //if we reach here, it means either j == n or we have a duplicate of c[j] in the substring (i, j-1)
            if(j == c.length) break;
            int temp = hmap.get(c[j]); //without this we get null pointer exception
            while( i <= temp ){
                hmap.remove(c[i]);
                i++;
            }
            hmap.put(c[j], j);
            j++;//forgot this before
        }
        return len;
    }
}
