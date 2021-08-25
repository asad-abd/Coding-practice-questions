public class _76_Minimum_Window_Substring_Hard {
    //add every s[j] in the hmap. notice that the equality condition of hmap.get(s[j]) == freq.get(s[j]) is only going to be met once. we can have more number of required chars in a window (it is completely ok)
    //keep removing from the window as long as it is VALID
    
    //note that we are checking the equality by equating the no. of unique chars count. which we increment if and only if the freq of unique also matches.
    
    //apparently, doesn't work for large test cases if not used .intValue()
    public String minWindow(String S, String T) {
        char s[] = S.toCharArray();
        char t[] = T.toCharArray();
        //if(t.length > s.length) return "";
        if (s.length == 0 || t.length == 0) {
          return "";
        }
        int n = s.length;
        HashMap<Character, Integer> freq = new HashMap<>();
        HashMap<Character, Integer> hmap = new HashMap<>();
        int i, j;
        for(i = 0; i < t.length; i ++)  
            freq.put(t[i], freq.getOrDefault(t[i], 0) + 1);
        int countReq = freq.size();
        int count = 0;
        i = 0; j = 0;
        int ans[] = {-1, 0, 0}; //{window length, i, j}
        while(j < n){
            //add the char, update the maps
            hmap.put(s[j], hmap.getOrDefault(s[j], 0) + 1);
            if(freq.containsKey(s[j]) && hmap.get(s[j]).intValue() == freq.get(s[j]).intValue())
                count ++;
            //keep moving i to right as long as the conditions are met.
            while(i <= j && count == countReq){
                if(ans[0] == -1 || j - i + 1 <= ans[0]){
                    ans[0] = j - i + 1;
                    ans[1] = i;
                    ans[2] = j;
                }
                //remove s[i]
                hmap.put(s[i], hmap.get(s[i]) - 1);// remember we're pushing all s[] chars in the hmap<> one while only req in freq<>
                if(freq.containsKey(s[i]) && hmap.get(s[i]).intValue() < freq.get(s[i]).intValue())
                    count --;
                i++;
            }
            j++;
        }
        //System.out.println(Arrays.toString(ans));
        if(ans[0] == -1) return "";
        return S.substring(ans[1], ans[2] + 1);
    }
}
