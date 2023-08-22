class StockSpanner {
    // NGL type
    Stack<int[]> st;
    // stack has <number, span_on_left>, where 'span_on_left' is the number of numbers of the left less than or equal to 'number'

    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        int span = 1; // default
        
        while(st.size() > 0){
            int prev_day_price = st.peek()[0];
            int prev_span = st.peek()[1];

            if(prev_day_price > price) break; // stop poping
            
            else{
                span += prev_span;
                st.pop();
            }
        }
        st.push(new int[]{price, span});

        return span;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */