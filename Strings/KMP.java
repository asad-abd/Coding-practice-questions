import java.util.*;

//my thinking approach for KMP- DFA with dynamic input!! - similar approach to aho corasick algorithm
//KMP + my little variation of it.
class KMP {
    public static List<Integer> LPS(String p) {
        int i = 0, j = 0, n = p.length();
        List<Integer> lps = new ArrayList<Integer>();
        while (j < n) {
            lps.add(i);
            if (p.charAt(i) == p.charAt(j))
                i++;
            else {
                i = lps.get(i);
            }
            j++;
            System.out.println(lps.get(j));
        }
        return lps;
    }

    public static List<Integer> kmp(String s, String patt) {
        List<Integer> lps = LPS(patt);
        List<Integer> ansIndex = new ArrayList<Integer>();
        int n = s.length(), m = patt.length();
        for (int i = 0, j = 0; i < n; i++) {
            if (s.charAt(i) == patt.charAt(j)) {
                j++;
            } else {
                j = lps.get(j);
            }
            if (j == m) {
                j = lps.get(j - 1);
                ansIndex.add(i);
            }
        }
        return ansIndex;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String patt = sc.nextLine();
        if (s.length() < patt.length()) {
            System.exit(0);
        }
        List<Integer> ansIndex = kmp(s, patt);
        System.out.println("Index/Indices of matching:- ");
        for (int i = 0; i < ansIndex.size(); i++) {
            System.out.print(ansIndex.get(i) + " ");
        }
    }
}