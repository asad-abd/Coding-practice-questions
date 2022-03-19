public class _1081_same_as_316 {
    // same as _316
    public String smallestSubsequence(String S) {
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
