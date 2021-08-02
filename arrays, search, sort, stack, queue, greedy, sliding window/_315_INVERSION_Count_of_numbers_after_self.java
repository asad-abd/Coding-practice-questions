class _315_INVERSION_Count_of_numbers_after_self {
    class Element{
        int val, pos;
        Element(int Val, int Index){
            val = Val;
            pos = Index;
        }
    }
    public void merge(Element nums[], int st, int m, int end, int ans[]){
        Element lhs[] = new Element[m - st + 1];
        Element rhs[] = new Element[end - m];
        int k = st;
        int i,j;
        for(i = 0; i < lhs.length; i++, k++)
            lhs[i] = new Element(nums[k].val, nums[k].pos);
        
        for(i = 0; i < rhs.length; i++, k++)
            rhs[i] = new Element(nums[k].val, nums[k].pos);
        
        //solve the sub ans --------------------------- this section is the only addition to merge sort
        i = 0; j = 0;
        for(i = 0; i < lhs.length; i++){
            while(j< rhs.length && lhs[i].val>rhs[j].val){//imp to avoid overflow
                //no issue / no inversions
                j++;
            }
            ans[lhs[i].pos] += (j);
        }
        // --------------------------------------------- 
        
        //merge (sort - to return to the parent sub-problem)
        i = 0; j = 0; k = st;
        while(i < lhs.length && j < rhs.length){
            if(lhs[i].val < rhs[j].val){
                nums[k] = lhs[i];
                i++;
            }
            else{
                nums[k] = rhs[j];
                j++;
            }
            k++;
        }
        while(j < rhs.length){
            nums[k] = rhs[j];
            j++;
            k++;
        }
        while(i < lhs.length){
            nums[k] = lhs[i];
            i++;
            k++;
        }
    }
    public void mergeSort(Element nums[], int st, int end, int ans[]){
        if(st<end){
            int m = st + (end - st) / 2;
            mergeSort(nums, st, m, ans);
            mergeSort(nums, m+1, end, ans);
            merge(nums, st, m, end, ans);
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        //trivial O(n^2) approach
        int n = nums.length;
        int ans[] = new int[n];//num, index
        Element numT[] = new Element[n];
        for(int i=0; i<n;i++)
            numT[i] = new Element(nums[i], i);
            
        //mergesort based O(nlogn) approach
        mergeSort(numT, 0, n-1, ans);
        ArrayList<Integer> result = new ArrayList<>();
        for(int i=0; i<n;i++)
            result.add(ans[i]);
        return result;
    }
}
