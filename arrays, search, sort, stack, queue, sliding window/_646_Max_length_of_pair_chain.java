class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs, new Comparator<>(){
            @Override
            public int compare(int a[], int b[]){
                return a[1] - b[1];
            }
        });
        int prevmax = Integer.MIN_VALUE;
        int count = 0;
        for(int a[]: pairs){
            if(a[0] > prevmax){
                prevmax = a[1];
                count ++;
            }
            
        }
        return count;
    }
}