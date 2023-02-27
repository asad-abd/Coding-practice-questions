class Solution {
    /**
    
    Given an array of integers temperatures represents the daily temperatures, return an array answer such that answer[i] is the number of days you have to wait after the ith day to get a warmer temperature. If there is no future day for which this is possible, keep answer[i] == 0 instead.
        
    BASICALLY: NEXT GREATEST ELEMENT generic
    move L <- R: push only if temp[stack top] larger than current

    */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int ans[] = new int[n];
        Stack<Integer> st = new Stack<Integer>();
        for(int i = n - 1; i >= 0; i --){
            int today = temperatures[i];
            while(st.size() > 0 && temperatures[st.peek()] <= today)
                st.pop();
            if(st.size() > 0)
                ans[i] = st.peek() - i;
            // else it's zero by default

            st.push(i); // don't forget this
        }
        return ans;
    }
}
