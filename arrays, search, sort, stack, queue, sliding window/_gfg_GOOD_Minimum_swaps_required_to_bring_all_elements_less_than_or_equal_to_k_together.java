class _gfg_GOOD_Minimum_swaps_required_to_bring_all_elements_less_than_or_equal_to_k_together {
    //naive O(n^2) approach. eg: ar = {2, 1, 5, 6, 3} and K = 3.
    //count the number of elements <= K -> 3 in the above example call it X. now, for each subarray of size X, check how many 
    //numbers in that subarray are larger than K. WHY?!!!! BECAUSE WE DON'T WANT THE NUMBERS > K IN THE SUBARRAY.
    //FINAL LOGIC: SO, NUMBER OF SWAPS REQUIRED IN THE ANSWER == NUMBER OF LARGER THAN K NUMBERS TO BE REMOVED FROM THE SUBARRAY!!!!

    //We can easily optimize the above algorithm to run in O(n) using sliding window

    //O(n) code:
    //advice: IN SLIDING WINDOW, TAKE CARE OF BOTH j AND j ENDING CONDITIONS IN ALL THE LOOPS
    public static int minSwap (int arr[], int n, int k) {
        int size=0;
        for(int i=0;i<n;i++)
            size += arr[i] <= k ? 1 : 0;

        //SMC        
        if(size<=1) return 0; //IMP condition. else IINF returned!!
        
        int i=0, j=0, countOfGreater=0;
        int ans=Integer.MAX_VALUE;
        while(j<n && j-i+1<=size ){
            while(j-i+1<=size && j<n){
                if(arr[j]>k) countOfGreater++;
                j++;
            }

            ans=Math.min(ans,countOfGreater);
            //move left pointer to the right
            
            //account for change in countOfGreater
            if(arr[i]>k) countOfGreater--;
            
            i++;
        }
        return ans;
    }
}
