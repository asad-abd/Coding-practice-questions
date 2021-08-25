//R1 Aug done
import java.util.*;
class _5_LongestPalindromicSubstring {
    //R1 Aug - 8ms (faster than 97.24%)
    int[] palindromeIndices(char s[], int i, int j){
        while(i >= 0 && j < s.length && s[i] == s[j]){
            i--;
            j++;
        }
        return new int[]{i + 1, j - 1};
    }
    public String longestPalindromeR1Aug(String S) {
        char s[] = S.toCharArray();
        
        int max = 0;
        int[] maxIndices = new int[2];
        //odd length substring
        for(int pivot = 0; pivot < s.length; pivot ++){
            int indices[] = palindromeIndices(s, pivot, pivot);
            if(indices[1] - indices[0] + 1 > max){
                max = indices[1] - indices[0] + 1;
                maxIndices[1] = indices[1];
                maxIndices[0] = indices[0];
            }
        }
        //even length substring
        for(int pivot = 0; pivot < s.length - 1; pivot ++){
            int indices[] = palindromeIndices(s, pivot, pivot + 1);
            if(indices[1] - indices[0] + 1 > max){
                max = indices[1] - indices[0] + 1;
                maxIndices[1] = indices[1];
                maxIndices[0] = indices[0];
            }
        }
        return S.substring(maxIndices[0], maxIndices[1] + 1);
        //return new String(s, maxIndices[0], max);
    }

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