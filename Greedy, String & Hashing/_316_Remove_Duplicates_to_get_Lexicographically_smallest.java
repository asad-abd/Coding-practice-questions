public class _316_Remove_Duplicates_to_get_Lexicographically_smallest {
    //thinking process:
    //we traverse the chars and maintain a char_taken DS. then we compare the current char with the last stored char in char_taken.
    //If the curr_char is smaller than last_stored one, we would like to remove it from lhs and decide to choose it later (if and only if it exists on the rhs of curr_char) 
    public String removeDuplicateLetters(String S) {
        char s[] = S.toCharArray();
        int n = s.length;
        boolean[] taken = new boolean[26];
        int lastIndex[] = new int[26];
        for(int i = 0; i < n; i ++)
            lastIndex[s[i] - 'a'] = i;
        
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < n; i ++){
            while(stack.size() > 0 && s[i] < stack.peek() && lastIndex[stack.peek() - 'a'] > i && !taken[s[i] - 'a']){
                //if s[i] is already taken, don't pop. ignore this instance of char
                char popped = stack.pop();
                taken[popped - 'a'] = false;
            }
            //System.out.println(stack);
            if(!taken[s[i] - 'a']){
                taken[s[i] - 'a'] = true;
                stack.push(s[i]);
            }
        }
        StringBuilder str = new StringBuilder();
        while(!stack.isEmpty())
            str.append(stack.pop());
        return str.reverse().toString();
    }
}
