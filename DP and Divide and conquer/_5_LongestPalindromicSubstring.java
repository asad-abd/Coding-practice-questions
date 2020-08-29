import java.util.*;

class _5_LongestPalindromicSubstring {
    // dp solution in 1 hr(bad :/). Redo later with center approach
    public String longestPalindrome(String s) {
        boolean[][] Palind = new boolean[s.length()][s.length()];
        int max = 1;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            Palind[i][i] = true;
            ans = "" + s.charAt(i);
        }
        for (int j = 1; j < s.length(); j++) {
            if (s.charAt(j - 1) == s.charAt(j)) {
                Palind[j - 1][j] = true;
                ans = "" + s.charAt(j - 1) + s.charAt(j);
                max = 2;
            } else {
                Palind[j - 1][j] = false;
            }
        }
        for (int d = 2; d < s.length(); d++) {
            for (int i = 0; i < s.length() && i + d < s.length(); i++) {
                if (s.charAt(i) == s.charAt(i + d)) {
                    if (Palind[i + 1][i + d - 1] == true) {
                        Palind[i][i + d] = true;
                        ans = s.substring(i, i + d + 1);
                        max = d + 1;
                    } else
                        Palind[i][i + d] = false;
                } else
                    Palind[i][i + d] = false;
            }

        }
        /*
         * for (int i = 0; i < s.length(); i++) { for (int j = 0; j < s.length(); j++) {
         * System.out.print(Palind[i][j] + "  "); } System.out.println(); }
         */
        return ans;
    }

    public static void main(String args[]) {
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));
    }
}