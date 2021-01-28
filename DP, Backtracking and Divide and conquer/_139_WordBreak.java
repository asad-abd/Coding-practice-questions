//the small addition of maxWordLength decreases time from 7ms to 1ms!
class _139_WordBreak {
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
