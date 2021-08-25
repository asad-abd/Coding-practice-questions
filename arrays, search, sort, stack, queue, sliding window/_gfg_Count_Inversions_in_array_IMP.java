class _gfg_Count_Inversions_in_array_IMP {
    //write merge sort and JUST ADD 1 LINE OF CODE
    //VVVVVVVVIMP re-assign inversions=0 in the main (calling) function - because, we need to reset the static, global variables!!!
    static long inversions=0;
    static long inversionCount(long arr[], long N)
    {
        inversions=0;//VVVVVVVVIMP - because, we need to reset the static, global variable!!!
        mergeSort(arr, 0, (int)N-1);
        return inversions;
    }
    static void merge(long arr[], int l, int m, int r)//conquer
    {
        //merge function - to merge arr[l,m] and arr[m+1,r];
        //REMEMBER THAT lhs and rhs are BOTH (already) SORTED INDIVIDUALLY!!!
        int i, j, k;
        int n1 = m - l + 1;
        int n2 = r - m; 
        long lhs[] = new long[n1];
        long rhs[] = new long[n2];
        
        for(i = l, k = 0, j = 0;i <= r; i++){
            if(i <= m)
                lhs[k++] = arr[i];
            else
                rhs[j++] = arr[i];
        }
        //merge
        i = 0; j = 0; k = l;
        while(i < n1 && j < n2){
            if(lhs[i] <= rhs[j]){
                //no issue / no inversions
                arr[k++] = lhs[i++];
            }
            else{
                //INVERSION!
                //since lhs[i]<=lhs[i+1]<=lhs[i+2]... -> i..(n1-1) are all counted in inversion
                inversions += (n1-i);
                arr[k++] = rhs[j++];
            }
        }
        while(i < n1){
            arr[k++] = lhs[i++];
        }
        while(j < n2)
            arr[k++] = rhs[j++];
        
    }
    static void mergeSort(long arr[], int l, int r)//divide - keep dividing
    {
        //call merge
        //divide and conquer
        if(l < r){
            int mid = l + (r - l)/2;
            mergeSort(arr, l, mid);
            mergeSort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
        
    }
}