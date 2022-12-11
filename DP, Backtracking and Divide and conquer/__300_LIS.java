class Solution {
    // LCS with sorted array isn't best suited for this because we are not allowed equal elements in the subsequence. (for non decreasing LCS would be go to)
    // (Soln 2) O(nlogn) 
    // https://leetcode.com/problems/longest-increasing-subsequence/discuss/1326552/Optimization-From-Brute-Force-to-Dynamic-Programming-Explained!

    // (Soln 1) For this question the simple O(n^2) solution is using dp:- 
    public int lengthOfLIS(int[] a) {
        int n = a.length;
        int lis_ending_at[] = new int[n];
        int ans = 1;
        for(int i = 0; i < n; i ++){
            int longest_pre_sub = 0;
            for(int j = 0; j < i; j ++){
                if(a[j] < a[i])
                    longest_pre_sub = Math.max(lis_ending_at[j], longest_pre_sub);
            }
            lis_ending_at[i] = 1 + longest_pre_sub;
            ans = Math.max(lis_ending_at[i], ans);
        }
        return ans;
    }
}