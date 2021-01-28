class _28_KMP_Zalgo {
    public int[] lps(String patt) {
        int i = 0;
        int lps[] = new int[patt.length()];
        for (int j = 1; j < patt.length(); j++) {
            // we will assign lps only if there is a match or if we reach i==0
            // otherwise we simply keep on changing i keeping j constant.
            if (patt.charAt(j) == patt.charAt(i)) {
                lps[j] = i + 1;
                // System.out.println(j+" <-j - i-> "+i+" "+lps[j]);
                i++;

            } else {
                if (i == 0) {
                    // mismatch with even the first character- 0 size prefix which is also a suffix!
                    lps[j] = 0;

                } else {
                    i = lps[i - 1];
                    j = j - 1;// because we haven't assigned any lps to this index yet.
                }

            }

        }

        return lps;
    }

    public int zAlgo(String str, String patt) {
        String s = patt + "*" + str;
        // added '*' because it cannot be present in any of the strings (given in
        // question)
        int zLength[] = lps(s);

        for (int i = patt.length() + 1; i < s.length(); i++) {
            if (zLength[i] == patt.length())
                return i - patt.length() - zLength[i];
        }
        return -1;
    }

    public int strStr(String haystack, String needle) {
        if (needle.length() == 0)
            return 0;
        int lps[] = lps(needle);
        // System.out.println(Arrays.toString(lps));

        return zAlgo(haystack, needle);
    }
}
