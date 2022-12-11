public class _209_Minimum_Size_Subarray_Sum {
    // soln 3: cumulative sum array => fix the left index (i) then binary search on the rhs indices for j (>i)

    // soln 2: cumulative sum array => use binary search to fix a window size. the smallest window size that satisfies the criteria is the answer
    //          logn to binary search on the size of array & O(n) to get all the sums for that window length in the array 
    
    // soln 1: O(n) 
    //just one '=' difference from "gfg_Smallest_subarray_with_sum_greater_than_x.java"
    public long sb(int a[], long n, long x) {
        //keep moving j if sum<x
        //when sum>=x increment i
        //keep moving i as long as sum>x
        long i=0, j=0, sum=0;
        long ans=Integer.MAX_VALUE;
        while(j<n && i<n){
            while(sum<x && j<n && i<n){
                sum+=a[(int)j];
                j++;
            }
            //j exits the loop at the next considering element so the size is j-i not j-i+1
            //ans=Math.min(ans,j-i+1);
            while(sum>=x && i<j){
                ans=Math.min(ans,j-i);
                sum-=a[(int)i];//deconsider ith element
                i++;
            }
        }
        return ans==Integer.MAX_VALUE?0: ans;
    }
    public int minSubArrayLen(int target, int[] nums) {
        return (int)sb(nums, (long)nums.length, (long)target);
    }
}
