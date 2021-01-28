class _974_Subarray_sums_Divisible_by_k {
    //read _1497 for more clarity
    //The catch in this question is the base case of starting with a freq of 1 for 0.

    //with array
    public int subarraysDivByK(int[] A, int k) {
        int count=0;
        int freq[]=new int[k];
        int cumSum=0;
        freq[0]=1;//This stmt is essentially like the base case (as cumSum is 0 initially so we increment freq of 0%k=0 by 1)
        for(int i=0;i<A.length;i++){
            cumSum+=A[i];
            int mod=cumSum%k;
            if(mod<0) mod+=k;
            count+=freq[mod];
            freq[mod]++;
        }
        
        return count;
    }
}
