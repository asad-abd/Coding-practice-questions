public class _125_Valid_Palindrome {
    public boolean isChar(char c){
        if(c>='a' && c<='z' || c>='A' && c<='Z'||c>='0'&&c<='9')
            return true;
        return false;
    }
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<=j){
            if(!isChar(s.charAt(i)))
                i++;
            else if(!isChar(s.charAt(j)))
                j--;
            else{//both are a-z/A-Z
                if(Character.toLowerCase(s.charAt(i))==Character.toLowerCase(s.charAt(j))){
                    i++;
                    j--;
                }
                else
                    return false;
            }
        }
        return true;
    }
}
