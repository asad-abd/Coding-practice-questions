class _155_Min_Stack {
    class MinStack {
        /** initialize your data structure here. */
        private Node head;
        public void push(int x) {
            if(head == null) 
                head = new Node(x, x);
            else{
                Node prevHead=head;
                head = new Node(x, Math.min(x, head.min));
                head.next=prevHead;
            }
        }
    
        public void pop() {
            head = head.next;
        }
    
        public int top() {
            return head.val;
        }
    
        public int getMin() {
            return head.min;
        }
        
        private class Node {
            int val;
            int min;
            Node next;
            
            private Node(int val, int min) {
                this.val = val;
                this.min = min;
            }
            
        }
    }
    
    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(x);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */
}
