public class __680_Valid_Plaindrome_2 {
    //trivial O(n^2)
    //check without removing for palind
    //remove all possible chars and then check.
    
    
    //O(n) - two pointer
    //i--> .. <--j. 
    //for a palindrome. if si == sj then the string s[i..j] must also be palindrome.
    //so search for the first i and j such that s[i] != s[j]
    //then check if removing i - s[i+1, j] gets us a palindrome
    //or if removing j - s[i, j-1] gets us a palindrome
    public boolean isPalid(char s[], int st, int end){
        int i = st, j = end;
        while(i < j){
            if(s[i] != s[j]) return false;
            i++;
            j--;
        }
        return true;
    }
    public boolean validPalindrome(String s) {
        char c[] = s.toCharArray();
        int i = 0, j = c.length - 1;
        while( i < j ){
            if(c[i] != c[j]){
                //System.out.println(c[i]+" -- "+c[j]);
                if(isPalid(c, i + 1, j))
                    return true;
                else if(isPalid(c, i, j - 1))
                    return true;
                else
                    return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
