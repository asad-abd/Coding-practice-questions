public class _3_Longest_Substring_without_repeating_characters {
    //first attempt: 2 pointer approach using hmap.
    //SMD1: temp = hmap.get(c[j]); //without this we get null pointer exception!! because after removing that num we are accessing it in the loop.
    //SMD2: forgot to do j++ once again at the end of the loop.
    public int lengthOfLongestSubstring(String s) {
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
