public class __844_Backspace_String_Compare {
    //M2: Ingenious! Two pointer - traverse from BACK!! 
    //O(n) time. O(1) space
    //O(n) time. O(1) space
    //Had WA Issue because I was not taking continuous deletions. eg: "a#b#' and 'ac##' (see WA code on leetcode)
    //keep deleting in the while loop till # is no more
    public boolean backspaceCompare(String s, String t) {
        int i = s.length() - 1;
        int j = t.length() - 1;
        while(i >= 0 || j >= 0){
            int ci = 0, cj = 0;
            while(i >= 0){
                if(s.charAt(i) == '#'){
                    ci++;
                    i--;
                }
                else if(ci > 0){
                    ci--;
                    i--;
                }
                else
                    break;
            }
            while(j >= 0){
                if(t.charAt(j) == '#'){
                    cj++;
                    j--;
                }
                else if(cj > 0){
                    cj--;
                    j--;
                }
                else
                    break;
            }
            //System.out.println(i+"\tj: "+j);
            
            if(i >= 0 && j >= 0 && s.charAt(i) != t.charAt(j)) return false;
            if(i >= 0 && j < 0 || j >= 0 && i < 0) return false;
            i--;
            j--;
        }
        return true;
    }

    //M1: O(n) time. O(n) space
    public String evaluateBackSpace(String S){
        char s[] = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length; i ++){
            if(s[i] != '#')
                stack.push(s[i]);
            else{
                if(stack.size() > 0)
                    stack.pop();
            }
        }
        StringBuilder str = new StringBuilder();
        while(stack.size() > 0)
            str.append(stack.pop());
        return str.toString();
    }
    public boolean backspaceCompareM1(String S, String T) {
        
        if(evaluateBackSpace(S).equals(evaluateBackSpace(T)))
            return true;
        return false;
    }
}
