class _905_Sort_array_by_parity {
    //inplace, one pass, like _75
    public int[] sortArrayByParity(int[] A) {
        //similar of _75_sort 0 1 2
        int lastIndexOfEven = -1, lastIndexOfOdd = -1,temp;
        for(int i=0;i<A.length;i++){
            if(A[i]%2==0){//even
                lastIndexOfEven++;
                //since we're placing even, at the new last index of even, which is also the first index of odd. swap A[i] with the new and incremented last index of odd
                if(lastIndexOfOdd==-1){
                    A[lastIndexOfEven]=A[i];
                    lastIndexOfOdd++;
                }else{
                    //now lastIndexOfEven is on some odd num.
                    temp=A[lastIndexOfEven];
                    A[lastIndexOfEven]=A[i];
                    A[++lastIndexOfOdd]=temp;
                }
            }
            else{//odd
                lastIndexOfOdd++;
                A[lastIndexOfOdd]=A[i];
            }
        }
        return A;
    }
}
