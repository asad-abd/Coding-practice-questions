class _389_FindTheDifference {
    // my solution
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] s2 = t.toCharArray();
        int i;
        Arrays.sort(s2);
        Arrays.sort(s1);
        // System.out.println((new String(s1))+"\n"+(new String(s2)));
        for (i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return s2[i];
            }
        }
        return s2[i];
    }

    // XOR solution!! O(n)
    public char findTheDifference(String s, String t) {
        char c = 0;
        int i;
        for (i = 0; i < s.length(); i++) {
            c = (char) ((c ^ s.charAt(i)) ^ t.charAt(i));
        }
        c ^= t.charAt(i);
        return c;
    }

}