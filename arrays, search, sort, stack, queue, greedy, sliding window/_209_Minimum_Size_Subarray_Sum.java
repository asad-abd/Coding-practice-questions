public class _209_Minimum_Size_Subarray_Sum {
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
