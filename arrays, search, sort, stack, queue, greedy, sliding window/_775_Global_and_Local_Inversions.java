public class _775_Global_and_Local_Inversions {
    //lee215: all global inversions in permutations are local inversions
    //In other words, max(A[i]) < A[i+2] - other simple approach
    public boolean isIdealPermutation(int[] nums) {
        //permutation of numbers    0,1,...n-1 - KEEP in mind
        //since only one local inversion is allowable, rest numbers should be sorted.
        //assuming the whole array is sorted, we have that nums[i]-i==0.
        //for the inverted part, nums[j]>nums[j+1] -> nums[j]=j+1 && nums[j+1]==j.
        for(int i=0;i<nums.length;i++){
            if(Math.abs(nums[i]-i)>1)
                return false;
        }
        return true;
    }
}
