/*#2439

You are given a 0-indexed array nums comprising of n non-negative integers.

In one operation, you must:

Choose an integer i such that 1 <= i < n and nums[i] > 0.
Decrease nums[i] by 1.
Increase nums[i - 1] by 1.
Return the minimum possible value of the maximum integer of nums after performing any number of operations.

 

Example 1:

Input: nums = [3,7,1,6]
Output: 5
Explanation:
One set of optimal operations is as follows:
1. Choose i = 1, and nums becomes [4,6,1,6].
2. Choose i = 3, and nums becomes [4,6,2,5].
3. Choose i = 1, and nums becomes [5,5,2,5].
The maximum integer of nums is 5. It can be shown that the maximum number cannot be less than 5.
Therefore, we return 5.
Example 2:

Input: nums = [10,1]
Output: 10
Explanation:
It is optimal to leave nums as is, and since 10 is the maximum value, we return 10.
 

Constraints:

n == nums.length
2 <= n <= 105
0 <= nums[i] <= 10^9
*/

/*
1,2,3,4,5 =>
1 2 3 5 4 => 1 2 4 4 4 => 2 1 4 4 4 => 2 3 2 4 4 => 2 3 3 3 4 => 3 3 3 2 4 => 3 3 3 3 3 (both side increase-decrease)

1 2 3 4 5 => 2 1 3 4 5 => 2 3 1 4 5 => 2 3 3 2 5 =>  2 3 3 4 3 => 3 2 3 4 3 => 3 3 3 3 3 (one side)

we're basically shifting the excess from right to left 
5 4 3 2 1 =>
5 6 1 2 1 => 
lets say 3 is answer
[2, 1, 0, -1, -2]


1 2 5 2 7 => consider 4 to be the answer => [-3 (can have 3 more units), -2, 1, -2, 3] => move left to right keeo note of empty space. if excess liquid encountered shift to right
=> 3 excess
=> 5 excess
=> 4 excess
=> 6 excess
=> 3 excess (reached end of array) -> if excess liquid is >= 0 answer is possible if ans is 4. and if at any point < 0 then not possible

now decrease possible answer to 4 => [-2, -1, 2, -1, 4]
=> 2 excess (i = 0)
=> 3 excess (i = 1)
=> 1 excess 
=> 2 excess
=> -2 excess -> 3 as answer is not possible 
*/
class Solution{
    public boolean verify(int nums[], int ans){
        long excess = 0;
        for(int num: nums){
            excess += (ans - num);
            if(excess < 0)
                return false;
        }
        if(excess < 0)
            return false;
        return true;
    }
    public int minimizeArrayValue(int[] nums) {
        int n = nums.length;
        // say that x is answer and then check if it is possible or not
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, mid;
        int ans = max;
        for(int num: nums){
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        while(min <= max){
            mid = min + (max - min) / 2;
            if(verify(nums, mid)){
                // check if smaller answer possible, update ans
                max = mid - 1;
                ans = mid;
            }
            else{
                // check if larger answer possible
                min = mid + 1;
            }
        }
        return ans;
    }
}
