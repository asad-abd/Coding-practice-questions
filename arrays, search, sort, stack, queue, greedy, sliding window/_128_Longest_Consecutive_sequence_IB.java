class _128_Longest_Consecutive_sequence_IB {
    //GOOD QUESTION: have done it before on IB
    
    //one approach is Bucket sort: boolean marked array

    //using hset: Fill the hashset first. 
    //then search for the starting points of the possible sequences
    //then for from from the starting points to count the length.
    public int longestConsecutive(int[] arr) {
        int max=0, sum;
        HashSet<Integer> hset = new HashSet<>();
	    for(int num: arr)
            hset.add(num);
        //try to find the starting point of the different sequences
        //number 'p' is a starting point if hset doesn't contain(p-1)
        //O(2*n) worst case running.
        for(int num: arr){
            sum=0;
            //if the hset has num-1. don't start the sequence from num.
            if(!hset.contains(num-1))
                while(hset.contains(num)){
                    sum++;
                    max=Math.max(sum, max);
                    num++;
                }
        }
	    return max;
    }
    //@ie334: One way to think of this problem. We have a set of nodes in a graph (nums[]). 
    //We want to find the largest connected component. components are connected if they are a consecutive sequence. 
    //So starting at each point, go -1 and +1 to find the largest connected component. Use a set to keep track of visited.

    /* HMAP SOLUTION
    try visualizing on the number line

    use a hash map to store BOUNDARY INFO of consecutive sequence for each element; there are 4 cases when a new element i reached:
    neither i+1 nor i-1 has been seen: m[i]=1;
    both i+1 and i-1 have been seen: extend m[i+m[i+1]] and m[i-m[i-1]] to each other;
    only i+1 has been seen: extend m[i+m[i+1]] and m[i] to each other;
    only i-1 has been seen: extend m[i-m[i-1]] and m[i] to each other.
    */
}
