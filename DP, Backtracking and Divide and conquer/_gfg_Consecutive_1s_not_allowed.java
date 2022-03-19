//https://practice.geeksforgeeks.org/problems/consecutive-1s-not-allowed1912/1#
public class _gfg_Consecutive_1s_not_allowed {
    //if the ith length number is ending with '0' then it can be put after 0 or 1
    //if the ith length number is ending with '1' then it can be put ONLY after a 0.
    long countStrings(int n) {
        int mod = 1000000000 + 7;
        long zeroEnd[] = new long[n + 1]; // zeroEnd[i] stores the number of numbers of length i and ending with 0.
        long oneEnd[] = new long[n + 1]; // oneEnd[i] stores the number of numbers of length i and ending with 1.
        zeroEnd[1] = 1;
        oneEnd[1] = 1;
        for(int i = 2; i <= n; i ++){
            //if the ith length number is ending with '0' then it can be put after 0 or 1
            zeroEnd[i] = (zeroEnd[i - 1] + oneEnd[i - 1]) % mod;
            
            //if the ith length number is ending with '1' then it can be put ONLY after a 0.
            oneEnd[i] = zeroEnd[i - 1];
        }
        return (oneEnd[n] + zeroEnd[n]) % mod;
    }
}
