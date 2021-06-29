class gfg_Smallest_subarray_with_sum_greater_than_x {
    //typical sliding window
    //SMC in the i and j while loops regarding sum
    //increase j as long as the sum is LESS than OR EQUAL TO x
    //decrease i as long as the sum is GREATER THAN x
    public static long sb(long a[], long n, long x) {
        //keep moving j if sum<x
        //when sum>=x increment i
        //keep moving i as long as sum>x
        long i=0, j=0, sum=0;
        long ans=n;
        while(j<n && i<n){
            while(sum<=x && j<n && i<n){
                sum+=a[(int)j];
                j++;
            }
            //j exits the loop at the next considering element so the size is j-i not j-i+1
            //ans=Math.min(ans,j-i+1);
            while(sum>x && i<j){
                ans=Math.min(ans,j-i);
                sum-=a[(int)i];//deconsider ith element
                i++;
            }
        }
        return ans;
    }
}
