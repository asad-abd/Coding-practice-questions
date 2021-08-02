public class _403_FROG_JUMP_hard {
    //2. DFS Solution


    //1. DP Solution 
    //We'll make each stone store the possible distance it can jump AHEAD from its current position.
    //stone 0 can jump only 1 step.
    //SILLY MISTAKE DONE: some t[i] can be empty. it doesn't matter as long as t[n-1] is non empty!!
    public boolean canCross(int[] stones) {
        //first jump MUST be 1 unit only (given)
        int n = stones.length;
        HashSet<Integer> t[] = new HashSet[n];
        
        for(int i = 0; i < n; i ++){
            t[i] = new HashSet<Integer>();
            if(i == 0)
                t[i].add(1);//as per the problem stmt
            for(int j = 0; j < i; j ++){
                //if we can reach the i'th stone from the j'th ones.
                //we can make k-1 and k+1 size jumps from i'th to (i+1)'th.
                int k = stones[i] - stones[j];
                if(t[j].contains(k)){
                    if(i == n - 1)
                        return true;
                    t[i].add(k);
                    t[i].add(k - 1);
                    t[i].add(k + 1);
                }
                
            }
            //System.out.println(t[i]);
        }
        return false;
        //frog can reach the last stone if k (= stones[n-1] - stones[j]) is present in any of the hashsets t[j].
    }
}
