/*
number of LIS

LIS -> |//
[1 4 3 2 5]

1 4 5
1 3 5
number of LIS ending at i

*/
// Straight forward -> just think normally

class Solution {
    public int findNumberOfLIS(int[] a) {
        int n = a.length;
        int llis[] = new int[n]; // length of the LIS ending at i
        int nlis[] = new int[n]; // freq/number of the longest increasing subsequences ending at 'i' whose length is llis[i]

        int longest = 0, ans = 0;

        for(int i = 0; i < n; i ++){
            llis[i] = 1; // imp
            nlis[i] = 1; // imp
            for(int j = 0; j < i; j ++){
                if(a[i] > a[j]){
                    if( llis[j] + 1 > llis[i] ){
                        llis[i] = llis[j] + 1;
                        nlis[i] = nlis[j];
                    }
                    else if( llis[j] + 1 == llis[i] ){
                        nlis[i] += nlis[j];
                    }
                }
            }
            longest = Math.max(longest, llis[i]);
        }

        // find the count of the maximum lengths
        for(int i = 0; i < n; i ++){
            if(llis[i] == longest)
                ans += nlis[i];
        }
        return ans;
    }
}
