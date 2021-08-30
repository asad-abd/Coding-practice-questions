class _935_Knight_Dialer {
    //recursive solution: someone else's 
    private long paths(int i, int j, int n) {
        // if the knight hops outside of the matrix or to * return 0 
        //as there are no unique paths from here
        if(i < 0 || j < 0 || i >= 4 || j >= 3 || (i == 3 && j != 1)) return 0;// THIS IS WHERE WE TAKE CARE OF NON DIGITS (#, *)
        //trivial case
        if(n == 1) return 1;
        //non trivial case
        long s = paths(i - 1, j - 2, n - 1) % max + // jump to a
                 paths(i - 2, j - 1, n - 1) % max + // jump to b
                 paths(i - 2, j + 1, n - 1) % max + // jump to c
                 paths(i - 1, j + 2, n - 1) % max + // jump to d
                 paths(i + 1, j + 2, n - 1) % max + // jump to e
                 paths(i + 2, j + 1, n - 1) % max + // jump to f
                 paths(i + 2, j - 1, n - 1) % max + // jump to g
                 paths(i + 1, j - 2, n - 1) % max; // jump to h
        return s;
     }

    // MY solution 1: (done on own)
    //like mobile numeric keypad IG
    //return how many distinct phone numbers of length n we can dial.
    public int knightDialer(int n) {
        //basically same as mobile numeric keypad - using digit do
        //dp[i][j] is the no. of numbers of length j and ending with 'i' (note: we aren't saying anything regarding the starting!)
        long mod = (int)Math.pow(10, 9) + 7;
        int ans = 0;
        long dp [][] = new long[10][n + 1];
        for(int i = 0; i < 10; i ++)
            dp[i][1] = 1;
        for(int j = 2; j <= n; j ++){
            dp[0][j] = (dp[4][j - 1] + dp[6][j - 1]) % mod;
            //we get 0 in the jth pos if the j - 1 pos had 4 or 6. And so on for other numbers
            dp[1][j] = (dp[6][j - 1] + dp[8][j - 1]) % mod;
            dp[2][j] = (dp[7][j - 1] + dp[9][j - 1]) % mod;
            dp[3][j] = (dp[4][j - 1] + dp[8][j - 1]) % mod;
            dp[4][j] = (dp[0][j - 1] + dp[3][j - 1] + dp[9][j - 1]) % mod;
            dp[6][j] = (dp[0][j - 1] + dp[1][j - 1] + dp[7][j - 1]) % mod;
            dp[7][j] = (dp[2][j - 1] + dp[6][j - 1]) % mod;
            dp[8][j] = (dp[1][j - 1] + dp[3][j - 1]) % mod;
            dp[9][j] = (dp[2][j - 1] + dp[4][j - 1]) % mod;
        }
        for(int i = 0; i < 10; i ++)
            ans = (ans + (int)dp[i][n]) % (int)mod ;
        return ans;
    }
    
    
    /* seems like something is missing in the below code
    //create a map of possible numbers reachable by the horse jump while standing on i
        int neighs[][] = {
            {4, 6}, // can jump to 4 and 6 from 0 
            {8, 6}, // 1
            {7, 9}, // 2
            {4, 8}, // 3
            {0, 9, 3}, // 4
            {}, // can go no where from 5
            {0, 7, 1}, // 6
            {2, 6}, // 7
            {1, 3}, // 8
            {4, 2} // 9
        };
        int numNeigh[] = {2, 2, 2, 2, 3, 0, 3, 2, 2, 2};
        int ans = 0;
        int mod = (int)Math.pow(10, 9) + 7; 
        if(n == 1)
            return 10;
        for(int st = 0; st < 10; st ++){
            
            Queue<Integer> q = new LinkedList<>();
            q.add(st);
            for(int c = 1; c < n ; c ++){
                int size = q.size();
                for(int i = 0; i < size; i ++){
                    int curr = q.poll();
                    System.out.print(curr + "   ");
                    ans = (ans + 1) % mod;
                    for(int neigh : neighs[curr])
                        q.add(neigh);
                }
            }
            System.out.println();
        }
        return ans;
    */
}
