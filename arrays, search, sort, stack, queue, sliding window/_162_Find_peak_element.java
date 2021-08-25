public class _162_Find_peak_element {
    //if nums[i] != nums[i + 1] is not given then this cannot be used
    public int findPeakElement(int[] nums) {
        //see the 1, n at the end
        //  a[i-1] < a[i] > a[i+1] 
        int n = nums.length;
        if(n == 1) return 0;
        if(nums[0] > nums[1]) return 0;
        if(nums[n-1] > nums[n-2]) return n-1;
        
        int st = 0, end = nums.length - 1;
        while (st < end) {
            int mid = st + (end - st) / 2;
            if (nums[mid] > nums[mid + 1])
                end = mid;
            else
                st = mid + 1;
        }
        return st; //st == end
    }
}
