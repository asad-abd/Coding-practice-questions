public class _232_Implement_Queue_using_stacks {
    //2 stack soln: read the soln on leetcode if confused
    //if s2 is not empty then the pop and peek happen in O(1) time
    
    /** Initialize your data structure here. */
    Stack<Integer> s1;
    Stack<Integer> s2;
    public MyQueue() {
        s1 = new Stack<>();//in LIFO
        s2 = new Stack<>();//in FIFO order 
    }
    
    /** Push element x to the back of queue. */
    public void push(int x) {
        s1.push(x);
    }
    
    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        if(s2.isEmpty()){
            while(s1.size() > 0)
                s2.push(s1.pop());
        }
        return s2.pop();
    }
    
    /** Get the front element. */
    public int peek() {
        if(s2.isEmpty()){
            while(s1.size() > 0)
                s2.push(s1.pop());
        }
        return s2.peek();
    }
    
    /** Returns whether the queue is empty. */
    public boolean empty() {
        return s1.isEmpty() && s2.isEmpty();
    }
}
