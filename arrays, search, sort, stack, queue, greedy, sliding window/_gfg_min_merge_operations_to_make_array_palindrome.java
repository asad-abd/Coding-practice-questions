class _gfg_min_merge_operations_to_make_array_palindrome {
    //easy one

    //i=0, j=n-1
    // If arr[i] == arr[j], then there is no need to do any merging operations at index i or index j. Our answer in this case will be f(i+1, j-1).
    // Else, we need to do merging operations. Following cases arise.
    // If arr[i] > arr[j], then we should do merging operation at index j. We merge index j-1 and j, and update arr[j-1] = arr[j-1] + arr[j]. Our answer in this case will be 1 + f(i, j-1).
    // For the case when arr[i] < arr[j], update arr[i+1] = arr[i+1] + arr[i]. Our answer in this case will be 1 + f(i+1, j).
    // Our answer will be f(0, n-1), where n is the size of array arr[].
}
