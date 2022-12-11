/*
214. Shortest Palindrome

You are given a string s. You can convert s to a palindrome by adding characters in front of it.

Return the shortest palindrome you can find by performing this transformation.

 

Example 1:

Input: s = "acecaaa"
Output: "aaacecaaa"
Example 2:

Input: s = "abcd"
Output: "dcbabcd"
 

Constraints:

0 <= s.length <= 5 * 104
s consists of lowercase English letters only.

class Solution {
    String ans;
    public int makePalindromeLength(StringBuilder str, int midL, int midR) {
        int n = str.length();
        while(midL >= 0 && midR < n) {
            if(str.get(midL) != str.get(midR))
                return -1;
            else
        }
    }
    public String shortestPalindrome(String s) {
        ans = "";

    }
}
*/

/*

Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.

 
Example 1:

Input: n = 5
Output: 5
Explanation:
Here are the non-negative integers <= 5 with their corresponding binary representations:
0 : 0
1 : 1
2 : 10
3 : 11
4 : 100
5 : 101
Among them, only integer 3 disobeys the rule (two consecutive ones) and the other 5 satisfy the rule. 
Example 2:

Input: n = 1
Output: 2
Example 3:

Input: n = 2
Output: 3
*/

class Solution {
    public int findIntegers(int n) {
        
    }
}


// number of non-negative Integers without Consecutive Ones less than n
// Given a positive integer n, return the number of the integers in the range [0, n] whose binary representations do not contain consecutive ones.
/*
So for a number n, at every bit that is a set to a 1, we are replacing it with a 0 then counting the number of remaining bits to the right of it.

Example:
"[1]110" -> "[0]XXX"
[1] indicates the bit we are at, there are 3 bits to the right hence 3 X's

XXX = F(3) = third fibonacci number --> There are F(3) ways to make XXX have non-consecutive 1's --> Add F(3) to count

"1[1]10" -> "1[0]XX"

XX = F(2) --> Add F(2) to the count

"11[1]0" -> "11[0]X"

Note that here, X = F(1) --> There are F(1) ways to make X have non-consecutive 1's but we cannot add F(1) to the count because no matter what you change X to,
the number is already invalid.
*/

/*
My logic: every bit whose previous bit is not 1 could have 1 and 0 as valid bits. But if in the number n(that we are given) 
    if there is such a bit s.t. that bit == 0 && prev_bit == 0 then we have to delete the case when 'bit' could have been set to 1 that is f[bits in n] - f[digits in bit - 2]

*/
class Solution {
    public int findIntegers(int num) {
        long t[] = new long[33];
        t[0] = 1; t[1] = 2;
        for(int i = 2; i <= 32; i ++)
            t[i] = t[i - 1] + t[i - 2];
        
        // t[i] => number of i bit numbers with no consecutive 1s

        // find the number of bits in number
        int n = 32; // MSB 
        for(int i = 32; i >= 0; i --){ // iterate over number of bits
            n = i;
            if((1<<i) & num == 1){
                break;
            }
        }
        
        // iterate from MSB to LSB
        int prev_bit = 0;
        long ans = f[n + 1];
        for(int bit = n; bit >= 0; bit --){
            if(((1<<bit) & num == 0)){
                if(prev_bit == 0)
                    ans = ans - f[Math.max(0, bit - 1)];
                prev_bit = 0;
            }
        }
        return (int)ans;
    }
}












