class Solution {
    public boolean increasingTriplet(int[] nums) {
        // Notice that any increasing subsequence [a1, a2, a3] will still be increasing if we replaced a2 with any other number in range (a1, a3) - (did this after nlogn soln of _300_lis) 
        
        // simply maintain a small and a big number count. If we encounter any number bigger than big we return true
        // logic is that we maintain list of size 2.
        // if we encounter a num less than a[0] but more than a[0] -> we replace with it with a[0]
        // else if we encounter a num less than a[1] but more than a[0] -> we replace it with with a[1]
        // else if we encounter a num greater than a[1] we've found our element
        // instead of a list we can do things with 2 vars. small, big
        if(nums.length < 3) return false;
        
        int small = Integer.MAX_VALUE;
        int big = Integer.MAX_VALUE;
        for(int num: nums){
            // check from left/smallest (like how we'd do in a list)
            if(num <= small) // '=' is imp!! for cases: [1,1,1,1,1]
                small = num;
            
            else if(num <= big) // && num > small) -> the reason we won't add this condition is because of the +IINF
                big = num;
            
            else 
                return true;
        }
        return false;
    }
}