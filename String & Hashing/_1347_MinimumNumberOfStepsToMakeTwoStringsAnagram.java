class _1347_MinimumNumberOfStepsToMakeTwoStringsAnagram {
    // checking for useless characters in t.
    // useless characters: a character occuring more in t than in s or a character
    // not in s.
    public int minSteps(String s, String t) {
        HashMap<Character, Integer> h1 = new HashMap<>();
        // HashMap <Character,Integer> h2=new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (h1.containsKey(ch))
                h1.put(ch, h1.get(ch) + 1);
            else
                h1.put(ch, 1);
        }
        int ans = 0;
        for (int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            if (h1.containsKey(ch)) {
                if (h1.get(ch) > 0)
                    h1.put(ch, h1.get(ch) - 1);
                // else we have a character occuring more in t than in s- useless
                else
                    ans++;
            } else
                ans++;
        }
        return ans;
    }
}
