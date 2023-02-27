/*
# Given an integer array nums and a positive integer k, return the most competitive subsequence of nums of size k.

# An array's subsequence is a resulting sequence obtained by erasing some (possibly zero) elements from the array.

# We define that a subsequence a is more competitive than a subsequence b (of the same length) if in the first position where a and b differ, subsequence a has a number less than the corresponding number in b. For example, [1,3,4] is more competitive than [1,3,5] because the first position they differ is at the final number, and 4 is less than 5.

 

# Example 1:

# Input: nums = [3,5,2,6], k = 2
# Output: [2,6]
# Explanation: Among the set of every possible subsequence: {[3,5], [3,2], [3,6], [5,2], [5,6], [2,6]}, [2,6] is the most competitive.
# Example 2:

# Input: nums = [2,4,3,3,5,4,9,6], k = 4
# Output: [2,3,3,4]
# */
class Solution {
    // stack solution
    /*
        [ 3, 5  -> 2 st.size = 1, elements left to consider including '2' are:
                                            i.  2 >= k -> we can afford to pop any number of objects from the stack
                                            ii.  if < k -> we can afford to pop only the number of objects left on the rhs including the element in consideration (n - )


    
    for an element nums[i]
         pop from stack until st.peek() > nums[i] UNLESS we won't be able to fill atleast k numbers
         push nums[i] only if size of stack < k
    DONE - just try seeing the Push and Pop operation is DISJUNCTION - NOT CONNECTED TO EACH OTHER. I.E. while pushing don't think about popping in between, do one and then do the other
    */
    public int[] mostCompetitive(int[] nums, int k) {
        Stack<Integer> st = new Stack<>();
        int n = nums.length;
        int i = 0;
        while(i < n){ // ----------> push 
            int nums_left = n - i;

            // check for conditions to pop
            // pop until st.peek() > nums[i] UNLESS we won't be able to fill atleast k numbers
            while(st.size() > 0 && st.peek() > nums[i] && ((nums_left + st.size() - 1) >= k)){ // ----------> pop 
                st.pop();
            }
            // push only if size of stack < k
            if(st.size() < k)
                st.push(nums[i]);
            i ++;
        }
        
        int arr[] = new int[st.size()];
        int j = st.size() - 1;
        while(st.size() > 0){
            arr[j--] = st.pop();
        }
        return arr;
    }
}
