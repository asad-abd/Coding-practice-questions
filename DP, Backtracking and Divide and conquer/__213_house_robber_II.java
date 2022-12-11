class Solution {
    /**
    case 1: odd number 
    [2 3 2] -> can select only 1!
    [2 7 9 4 5] -> can select only 2
    selecting int(n / 2) numbers

    [1 7 1 1 7]
    [7 1 1 1 7]

    case 2: even number
    [2 2 3 4] -> selecting n / 2 numbers

     */

    // BASICALLY NORMAL KNAPSACK WITH JUST DIFFERENT STARTING INDICES
    // if we select the last element then check only till the 2nd element
    // if we do not select the last element then we can check till the 1st element
    public int rob(int[] nums) {
        int t1[] = new int[nums.length + 1];
        int t2[] = new int[nums.length + 1];

        // important 
        if(nums.length == 1)
            return nums[0];
        for(int i = 0; i <= nums.length; i ++){
            t1[i] = -1;
            t2[i] = -1;
        }
        return  Math.max(knap(nums, 1, nums.length, t1), knap(nums, 0, nums.length - 1, t2));
    }
    public int knap(int a[], int st, int n, int t[]){
        if(n <= st)
            return 0;
        if(t[n] != -1)
            return t[n];
        if(n > 1){
            return t[n] = Math.max(a[n - 1] + knap(a, st, n - 2, t), knap(a, st, n - 1, t));
        }
        return t[n] = a[n - 1] + knap(a, st, n - 2, t);
    }
    
}
