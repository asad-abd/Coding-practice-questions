class _gfg_Count_pairs_with_given_sum {
    //only catch: dynamically insert in the hmap
    int getPairsCount(int[] arr, int n, int k) {
        HashMap<Integer,Integer> hmap = new HashMap<>();
        int count=0;
        /*for(int i=0;i<n;i++){
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
        }*/
        
        for(int i=0;i<n;i++){
            if(hmap.containsKey(k-arr[i])){
                count+=hmap.get(k-arr[i]);
            }
            hmap.put(arr[i],hmap.getOrDefault(arr[i],0)+1);
        }
        
        return count;
    }
}
