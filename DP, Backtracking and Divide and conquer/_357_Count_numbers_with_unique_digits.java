class Solution {
// digit db question. done after #600

// soln 2
// classic PnC problem: find for x digits(exact x digits) eg: [9|9|8|7] for first position we have 9 options (1-9), for 2nd we have (0-9) but since one is taken in first position we have 9 options. then it keeps decreasing 
// take sum of all such cases with digits <= n

// soln 1:
// AC for below but a little uncertain
// basically if we are at the 3rd digit(MSB), for each valid 2 digit solution we are only allowed to have (9 - 2) possible unique digits for it
// i.e., it we have xyz ->  assuming y and z are unique. the option of x reduced by 2
// now for each possible unique y and z combination we have 7 possible numbers
// therefore the number of 3 digit numbers with unique digits is 7 * f[2] 
// and the answer for all unique numbers whose num(digits) <= 3 is SUM(all f[d]; d <= 3) 

    public int countNumbersWithUniqueDigits(int n) {
        int f[] = new int [11];
        f[0] = 1;
        f[1] = 10;
        int cumSum = 11;
        for(int d = 2; d <= n; d ++){
            f[d] = (10 - d) * f[d - 1] + cumSum;
            cumSum += f[d];
        }
        return f[n];
    }
}
