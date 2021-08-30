import java.util.*;
class __493_INVERSIONS_Reverse_pairs_hard {
    //VVV IMP: don't change the merge sort algo. just add another linear loop to solve the additional problem!!
    
    //take lhs= [4,6,8] & rhs=[1,2,3].
    //FOR EACH i: we increase j till this condition holds true: lhs[i]>2*rhs[j] and add that j for each i.
    //SINCE lhs[i]<=lhs[i+1]- the numbers in rhs[0,j] which were less than lhs[i] will also be less than lhs[i+1]!!
    //the only addition for lhs[i+1] is that now lhs[i+1](might be)>2*rhs[j, j+1 ..]. so we need to find the last such j!!.
        
    int inversions=0;
    public int reversePairs(int[] nums) {
        inversions=0;//VVVVVVVVIMP - because, we need to reset the static, global variable!!!
        mergeSort(Arrays.copyOf(nums,nums.length), 0, nums.length-1);
        System.out.println(Arrays.toString(nums));
        return inversions;
    }
    
    public void merge(int arr[], int l, int m, int r)//conquer
    {
        //merge function - to merge arr[l,m] and arr[m+1,r];
        //REMEMBER THAT lhs and rhs are BOTH SORTED INDIVIDUALLY!!!
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
        
        //COUNT REVERSE - THE MAIN PART OF QUESTION 
        i=0; j=0; k=l;
        //take lhs= [4,6,8] & rhs=[1,2,3].
        //FOR EACH i: we increase j till this condition holds true: lhs[i]>2*rhs[j] and add that j for each i.
        //SINCE lhs[i]<=lhs[i+1]- the numbers in rhs[0,j] which were less than lhs[i] will also be less than lhs[i+1]!!
        //the only addition for lhs[i+1] is that now lhs[i+1](might be)>2*rhs[j, j+1 ..]. so we need to find the last such j!!.
        while(i<n1){
            while(j<n2 && (long)lhs[i]>2*(long)rhs[j]){//imp to avoid overflow
                //no issue / no inversions
                j++;
            }
            inversions+=(j);
            i++;
        }
        //END OF MAIN PART OF QUESTION (REST OF THE CODE IS JUST MERGE SORT)
        
        // merge to MAKE SORTED
        i=0; j=0; k=l;
        while(i<n1 && j<n2){
            if(lhs[i]<=rhs[j])
                arr[k++]=lhs[i++];
            else
                arr[k++]=rhs[j++];
        }
        while(i<n1){
            arr[k++]=lhs[i++];
        }
        while(j<n2)
            arr[k++]=rhs[j++];
        
    }
    public void mergeSort(int arr[], int l, int r)//divide - keep dividing
    {
        //call merge
        //divide and conquer
        if(l<r){
            int mid = l + (r-l)/2;
            mergeSort(arr,l,mid);
            mergeSort(arr,mid+1,r);
            merge(arr, l, mid, r);
        }
        //System.out.println(Arrays.toString(arr));
    }
}
