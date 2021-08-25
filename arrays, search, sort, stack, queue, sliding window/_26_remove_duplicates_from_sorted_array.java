class _26_remove_duplicates_from_sorted_array {
    public int removeDuplicates(int[] nums) {
        //2 pointer 
        //move j to right till num[i]!=num[j]
        //assign num[i+1] to num[j] -> j = j + 1
        int n = nums.length;
        if(n <= 1) return n;
        
        int i = 0, j = 1;
        while(j < n){
            while(j < n && nums[i] == nums[j])
                j++;
            
            if(j >= n) break;
            
            nums[i + 1] = nums[j];
            i = i + 1;
        }
        return i + 1;
    }
}
