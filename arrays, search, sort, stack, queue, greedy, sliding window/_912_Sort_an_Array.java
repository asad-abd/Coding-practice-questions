class _912_Sort_an_Array {
    //READ https://leetcode.com/problems/sort-an-array/discuss/492042/7-Sorting-Algorithms-(quick-sort-top-downbottom-up-merge-sort-heap-sort-etc.) for detail
    //1. QuickSort (on own) - AC with the random swap part
    //pivot is l. swap l with a random index in l-r
    //swap pivot+1 with the 'next' pointer.
    //then swap pivot with pivot++
    //after each run. the pivot is in its correct position.
    //recurse on lhs and rhs of pivot(exclusive)
    public void swap(int nums[], int x, int y){
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    public void quicksort(int nums[], int l, int r){
        if(l >= r) return;
        int random = l + (int)(Math.random()*(r - l));
        swap(nums, l, random);
        int pivot = l;
        int next = l + 1;
        while(next <= r){
            if(nums[pivot] >= nums[next]){
                //swap pivot + 1 with next 
                //and swap pivot with pivot++
                swap(nums, pivot + 1, next);
                swap(nums, pivot + 1, pivot);
                pivot++;
            }
            next++;
        }
        //System.out.println(Arrays.toString(nums));
        quicksort(nums, l, pivot - 1);
        quicksort(nums, pivot + 1, r);
        
    }
    public int[] sortArray(int[] nums) {
        quicksort(nums, 0, nums.length - 1);
        return nums;
    }
}
