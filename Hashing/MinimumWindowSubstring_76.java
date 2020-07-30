//Hard #76. google, ebay
//Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).
//understood the logic but don't want to find bugs :/
//bug fixes- in matching h and h1. if h1 has more val of no way of comparison
public class MinimumWindowSubstring_76 {
    public void updateH2(HashMap<String, Integer> h, HashMap<String, Integer> h1, HashMap<String, Integer> h2,
            String ch) {
        if (h1.get(ch) > h.get(ch))
            h2.put(ch, h.get(ch));
    }

    public String minWindow(String s, String t) {
        HashMap<String, Integer> h = new HashMap<String, Integer>();
        HashMap<String, Integer> h1 = new HashMap<String, Integer>();
        HashMap<String, Integer> h2 = new HashMap<String, Integer>();
        for (int i = 0; i < t.length(); i++) {
            String ch = "" + t.charAt(i);
            if (h.containsKey((String) ch)) {
                h.put(ch, h.get(ch) + 1);
            } else {
                h.put(ch, 1);
            }
            h1.put(ch, 0);
            h2.put(ch, 0);
        }

        int i = 0, j = 0, n = s.length(), len = 0;
        String ans = s;
        System.out.println("out of loop h  " + Arrays.toString(h.entrySet().toArray()));
        System.out.println("out of loop h1  " + Arrays.toString(h1.entrySet().toArray()));
        for (j = 0; j < n; j++) {
            System.out.println("j : " + j + " n: " + n);
            String ch = "" + s.charAt(j);
            if (h1.containsKey(ch)) {
                h1.put(ch, h.get(ch) + 1);
                updateH2(h, h1, h2, ch);
            }
            System.out.println(ch + " inside of loop h2  " + Arrays.toString(h2.entrySet().toArray()));
            if (h2.equals(h)) {
                len = j - i + 1;
                if (len < ans.length()) {
                    ans = s.substring(i, j);
                }
                // change things before incrementing i
                if (h1.containsKey(ch)) {
                    if (h1.get(ch) > 0) {
                        h1.put(ch, h1.get(ch) - 1);
                    } else {
                        h1.put(ch, 0);
                    }
                }
                updateH2(h, h1, h2, ch);
                i++;
                continue;
            }

            j++;
        }
        return ans;
    }
}