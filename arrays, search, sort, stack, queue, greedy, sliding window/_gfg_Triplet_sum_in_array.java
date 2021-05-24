class _gfg_Triplet_sum_in_array {
    public static boolean find3Numbers(int A[], int n, int x) { 
        //sort and 2 pointer
        Arrays.sort(A);
        
        for(int i=0; i<n-1; i++){
            int st=i+1, end=n-1;
            
            while(st<end){
                if(A[st]+A[end]==x-A[i])
                    return true;
                else if(A[st]+A[end]>x-A[i])
                    end--;
                else
                    st++;
            }
        }
        return false;   
    }
}
