public class _60_Permutation_Sequence_hard {
    //The set [1, 2, 3, ..., n] contains a total of n! unique permutations.
    //output the kth lexicographical sequence of [1,2,3..n]
    //M2: Math solution (try later)
    
    //M1: normal backtracking, since the array is already sorted. 
    //the sequences will be BY DEFAULT created in lexicographial order!!
    int count;
    String ans;
    public void permute(int arr[], int countTaken, boolean[] taken, List<Integer> tempList){
        if(count <= 0) return;
        if(countTaken == arr.length){
            if(count == 1){
                StringBuilder str = new StringBuilder();
                for(int item : tempList)
                    str.append(item);
                ans = str.toString();
            }
            count --;
            return;
        }
        
        for(int i = 0; i < arr.length; i ++){
            if(!taken[i]){
                //choose to take it or ignore it
                tempList.add(arr[i]);
                taken[i] = true;
                permute(arr, countTaken + 1, taken, tempList);
                tempList.remove(tempList.size() - 1);
                taken[i] = false;
            }
        }
    }
    public String getPermutation(int n, int k) {
        //make array of 1 - n.
        //back tracking
        count = k;
        int arr[] = new int[n];
        for(int i = 0; i < n; i ++)
            arr[i] = i + 1;
        permute(arr, 0, new boolean[n], new ArrayList<Integer>());
        return ans;
    }
}
