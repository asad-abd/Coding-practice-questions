class ___1335_Minimum_Difficulty_of_a_Job_schedule
{
    //redo later
    /*My Mistakes/ Silly Mistakes. THESE KIND OF MISTAKES ARE DEADLY!!
        1. Not figuring out properly the ending indices in loops!!!
            (this gave wrong answer for SOME cases - this can cause serious trouble!!)
        2. Passing too many parameters in the function call caused confusion
        
        3. Not practicing many question like this one to properly use dfs.

        4. Not knowing where to access t[i][j] (memoizing) properly!!
    */
    public int dfs(int arr[], int i, int dleft, int t[][]){
        if(dleft == 1){//we have already atleast 1 number for this box
             //output for the sub answer having only 1 box!
            int max = arr[i];
            while(i < arr.length){
                max = Math.max(max, arr[i++]);
            }
            return max;
        }
        //if(t[i][dleft] != -1) return t[i][dleft];//only using this one gives TLE!!.
        //mistake 4 ^^^^^

        int max = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        //we can go from current index till the index (end - dleft)
        for(; i <= arr.length - dleft; i ++ ){
            max = Math.max(max, arr[i]);
            if(t[i + 1][dleft - 1] == -1) 
                t[i + 1][dleft - 1] = dfs(arr, i + 1, dleft - 1, t);
            ans = Math.min(ans, max + t[i + 1][dleft - 1]);
        }
        //System.out.println(i + " | " + dleft + " | " + ans);
        return t[i][dleft] = ans;
    }
    public int minDifficulty(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) return -1;
        int n = jobDifficulty.length;
        int t[][] = new int[n][d + 1];
        for(int i = 0; i < n; i ++){
            for(int j = 0; j <= d; j ++)
                t[i][j] = -1;
        }
        return dfs(jobDifficulty, 0, d, t);
    }

    // RECURSIVE ONLY
    //tle but correct!!
    public int dfsRecur(int arr[], int i, int dleft){
        if(dleft == 1){//we have already atleast 1 number for this box
             //output for the sub answer having only 1 box!
            int max = arr[i];
            while(i < arr.length){
                max = Math.max(max, arr[i++]);
            }
            return max;
        }
        int max = Integer.MIN_VALUE;
        int ans = Integer.MAX_VALUE;
        //we can go from current index till the index (end - dleft)
        for(; i <= arr.length - dleft; i ++ ){
            max = Math.max(max, arr[i]);
            ans = Math.min(ans, max + dfsRecur(arr, i + 1, dleft - 1));
        }
        return ans;
    }
    public int minDifficultyRecur(int[] jobDifficulty, int d) {
        if(jobDifficulty.length < d) return -1;
        return dfsRecur(jobDifficulty, 0, d);
    }
}
    //thinking correct but wrong implementation!!
    //1. consider in current
    //2. consider in next
    /*public int knap(int arr[], int Max[], int n, int m, considerNext){
        if(n == 0 && m !=0 ) return Integer.MAX_VALUE;
        int max[] = Arrays.copyOf(Max, Max.length);
        if(m == 0){
            while(n > 0){
                max[0] = Math.max(max[0], arr[n - 1]);
                n --;
            }
            int sumOfMax = 0;
            for(int x: max)
                sumOfMax += x;
            //System.out.println("base: "+Arrays.toString(max));
            return sumOfMax;
        }
        //else 
        if(n > m){
            //1. consider in current
            //2. consider in next
            int maxSame[] = Arrays.copyOf(max, max.length);
            //consider in same 
            maxSame[m - 1] = Math.max(maxSame[m - 1], arr[n - 1]);
            //consider in next -> m - 1. assign arr[n - 1] as max[m - 1]

            //System.out.println("maxNext: "+Arrays.toString(max));
            //System.out.println("maxSame: "+Arrays.toString(maxSame));
return Math.min(knap(arr, maxSame, n - 1, m, false), knap(arr, max, n, m - 1, true));
        }
        else if(n < m) return Integer.MAX_VALUE;
        else{// n == m. number of rooms left == number of people
            
            int sumOfMax = 0;
            //haven't assigned the ones < m !!!!
            for(int i = m ; i < max.length; i++){
                sumOfMax += max[i];
                //System.out.println("Bltch");
            }
            while(n > 0){
                sumOfMax += arr[n - 1];
                n --;
            }
            System.out.println("else: "+Arrays.toString(max));
            return sumOfMax;           
        }
    }*/