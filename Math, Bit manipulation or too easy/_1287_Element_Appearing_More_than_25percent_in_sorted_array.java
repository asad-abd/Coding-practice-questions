class _1287_Element_Appearing_More_than_25percent_in_sorted_array {
    public int findSpecialInteger(int[] arr) {
        int count=1,req=0;
        if(arr.length%4 == 0)
            req=arr.length/4+1;
        else req=(arr.length+3)/4;
        
        for(int i=1;i<arr.length;i++){
            if(arr[i]==arr[i-1]){
                count++;
                if(count>=req)
                    return arr[i];
            }
            else
                count=1;
        }
        return arr[arr.length-1];
    }
}
