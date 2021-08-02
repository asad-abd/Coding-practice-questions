public class _49_Group_Anagrams {
    //trivial O(n*w*log(w)) approach:-
        //Map<String, List of indices> 
        //sort string before checking in the hmap -> w log w 
        //output all the lists corresponding to the keys
        
        //Similar but better O(n*w) approach: 
        //instead of sorting the word w. take freq count of a-z in freq[26]
        //then make key: "" + freq[0] + "," + freq[1] + "," + .. + freq[25].
        //output the lists.
        
        if (strs == null || strs.length == 0) return new ArrayList<>();
        HashMap<String, List<String>> hmap = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            int freq[] = new int[26];
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < c.length; i ++)
                freq[c[i] - 'a']++;
            for(int i = 0; i < 26; i ++){
                str.append(freq[i]);
                str.append('#');//dont forget this!!
            }
            //don't eliminate 0 freq from kash key or many different ones will have same key!! also don't forget the delimeter!
            String keyStr = str.toString();
            if (!hmap.containsKey(keyStr)) hmap.put(keyStr, new ArrayList<>());
            hmap.get(keyStr).add(s);
        }
        
        //UNIQUE WAY OF OUTPUTTING LIST OF LISTS!!
        return new ArrayList<>(hmap.values());
    }
}
