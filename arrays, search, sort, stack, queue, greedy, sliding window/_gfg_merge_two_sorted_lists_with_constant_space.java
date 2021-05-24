class _gfg_merge_two_sorted_lists_with_constant_space {
    //gap based algo. ceil((n+m)/2)
    //then gap = ceil(gap/2) (except if gap==1 -> break)

    public void swap(int arr1[], int arr2[], int i, int j){
        int temp=arr1[i];
        arr1[i]=arr2[j];
        arr2[j]=temp;
    }
    public void merge(int arr1[], int arr2[], int n, int m) {
        int gap = (n+m+1)/2;
        int i=0, j=gap;
        while(gap>0){
            i=0;j=i+gap;
            while(j<n+m){
                if(i<n && j<n){
                    if(arr1[i]>arr1[j])
                        swap(arr1, arr1, i, j);
                }
                else if(i<n && j>=n){
                    if(arr1[i]>arr2[j-n])
                        swap(arr1, arr2, i, j-n);
                }
                else if(i>=n && j>=n){
                    if(arr2[i-n]>arr2[j-n])
                        swap(arr2, arr2, i-n, j-n);
                }
                i++;
                j++;
                
            }
            //System.out.println(Arrays.toString(arr1)+" "+Arrays.toString(arr2));
            if(gap==1) break;
            if(gap%2==0) gap/=2;
            else gap=(gap+1)/2;
            
        }
        
    }
}
//for n^2 time algo with constant space. insertion sort type approach after swap in arr1[i] and arr2[j] - gfg see