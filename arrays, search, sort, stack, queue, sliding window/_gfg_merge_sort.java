class _gfg_merge_sort {
    //MOST IMPORTANT ADVICE: always consider [l,m] (m included) in the lhs!!!
    //JUST DO THE ABOVE to avoid silly blunders!!
    //important for count inversions
    void merge(int arr[], int l, int m, int r)
    {
        //merge function - to merge arr[l,m] and arr[m+1,r];
        int i, j, k;
        int n1=m-l+1;
        int n2=r-m;
        int lhs[] = new int[n1];
        int rhs[] = new int[n2];
        for(i=l,k=0,j=0;i<=r;i++){
            if(i<=m)
                lhs[k++]=arr[i];
            else
                rhs[j++]=arr[i];
        }
        // merge
        i=0; j=0; k=l;
        while(i<n1 && j<n2 ){
            if(lhs[i]<rhs[j])
                arr[k++]=lhs[i++];
            else
                arr[k++]=rhs[j++];
        }
        while(i<n1)
            arr[k++]=lhs[i++];
        
        while(j<n2)
            arr[k++]=rhs[j++];
        
    }
    void mergeSort(int arr[], int l, int r)
    {
        //call merge
        //divide and conquer
        if(l<r){
            int mid = l + (r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr, l, mid, r);
        }
        
    }
}
