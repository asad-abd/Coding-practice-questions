/*
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
 /*
Given an integer array nums and an integer k, return true if nums has a good subarray or false otherwise.

A good subarray is a subarray where:

its length is at least two, and
the sum of the elements of the subarray is a multiple of k.
Note that:

A subarray is a contiguous part of the array.
An integer x is a multiple of k if there exists an integer n such that x = n * k. 0 is always a multiple of k.
 

Example 1:

Input: nums = [23,2,4,6,7], k = 6
Output: true
Explanation: [2, 4] is a continuous subarray of size 2 whose elements sum up to 6.
Example 2:

Input: nums = [23,2,6,4,7], k = 6
Output: true
Explanation: [23, 2, 6, 4, 7] is an continuous subarray of size 5 whose elements sum up to 42.
42 is a multiple of 6 because 42 = 7 * 6 and 7 is an integer.
Example 3:

Input: nums = [23,2,6,4,7], k = 13
Output: false
 

Constraints:

1 <= nums.length <= 10^5
0 <= nums[i] <= 10^9
0 <= sum(nums[i]) <= 2^31 - 1
1 <= k <= 2^31 - 1
*/
/*
    Idea: 
        i.   Iterate from left to right and calculate the cumulative sum, 
        ii.  As we consider each element, store the new cum_sum % k (remainder) in a hashset. 
        iii. If we encounter the same remainder in the hashset it means that if we start from after that number (i.e., RHS of it) we get a subarray that satisfies the condition
        
        basic maths: if y % x = r (1)  &&  z % x = r (2) then (y - x) % r = 0. Basically: eqn 1 - eqn 2

        CATCH: since the minimum length is 2:   
        if k = 2, in [1, 0, 0] answer is true but in [1, 0] answer is false since just 0 cannot be answer.
        so, with the remainder also store its index and check the length of the indices

    err case: nums = [5,0,0,0]
              k = 3
    happened due to not putting }{ braces! the else was being taken for the second if..
*/  
class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Long, Integer> remainders = new HashMap<>(); // rems and index

        long sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            long r = sum % k;

            // if length >= 2
            if(i >= 1 && r == 0)
                return true;

            if(remainders.containsKey(r)){
                if(i - remainders.get(r) > 1)
                    return true;
            }
            else
                remainders.put(r, i);
        }
        return false;
    }
}
