public class __1027_Longest_Arithmetic_Subsequence {
    //Don't always think of LIS!!!
    
    //Good One. can use Hmap[] or 2D int array
    public int longestArithSeqLength(int[] nums) {
        int n = nums.length;
        
        int t[][] = new int[n][1001];
        //t[i][diff] stores the longest continuous AP till the i'th index with a difference of diff.
        //so, check all j < i and check, that for these two at the end of the AP, how many numbers before them were having the same diff!
        //since in one go we check 2 nums, we need to add 1 to the final answer.
        int ans = 0;
        for(int i = 0; i < n; i ++){
            for(int j = 0; j < i; j ++){
                //consider the i'th number to be the next in AP after the j'th number. (consider all j's less than i)
                int diff = nums[i] - nums[j] + 500;
                t[i][diff] = 1 + t[j][diff];
                
                ans = Math.max(t[i][diff], ans);
            }
        }
        return ans + 1;
    }
}
