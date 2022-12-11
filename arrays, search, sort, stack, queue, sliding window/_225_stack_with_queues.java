class MyStack{
    // basically you have to rotate the queue at every push op. -> O(n) for push. O(1) for rest
    Queue<Integer> que;
    /** Initialize your data structure here. */
    public MyStack() {
        que = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        que.add(x);
        for(int i=0; i<que.size()-1; i++) {
            que.add(que.poll());
        }
    }

    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        return que.remove();
        
    }

    /** Get the top element. */
    public int top() {
        return que.peek();
        
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return que.isEmpty();
        
    }
    
}