class _887_Super_egg_drop {
    //modifying O(kn^2) to be O(k*n*logn)!!
    //we need the minimum of the worst cases!! - weird right!
    public int eggDrop(int k, int n, int[][] t) {
        if(n==1 || n==0) return n;
        if(k==1) return n; // SINCE IN THE WORST CASE THE LAST FLOOR MAYBE THE ANSWER!!!
        if(t[k][n]!=-1) return t[k][n];
        //in the worst case if we, start dropping from a floor and keep moving up till it breaks and take the minimum of these cases as answer
        int ans=Integer.MAX_VALUE;
        int st=1, end=n;
        while(st>=1 && end<=n && st<=end){
            int i = st + (end-st)/2;
            //two possibilities: breaks on the current floor or doesn't
            if(t[k-1][i-1]==-1)
                t[k-1][i-1] = eggDrop(k-1, i-1, t);
            if(t[k][n-i]==-1)
                t[k][n-i] = eggDrop(k, n-i, t);
            ans = Math.min(ans, Math.max(t[k-1][i-1], t[k][n-i]));
            //Math.max(superEggDrop(k-1, i-1), superEggDrop(k,n-i)));
            //this is because we need the min of the worst case ans(MAX!!)
            
            //move towards the possibility that yeilds the worse case
            if(t[k-1][i-1]>t[k][n-i]){//the moves taken if it breaks on the current floor > moves if it doesn't break on the current floor
                end = i-1;
            }
            else
                st=i+1;
        }
        return t[k][n] = ans+1;
    }
    public int superEggDrop(int k, int n) {
        int t[][]=new int[k+1][n+1];
        for(int i=1;i<=k;i++)
            for(int j=1;j<=n;j++)
                t[i][j]=-1;
            
        return eggDrop(k,n,t);
    }

    //AC on gfg. tle on leetcode: https://practice.geeksforgeeks.org/problems/egg-dropping-puzzle-1587115620/1#
    //MOST IMP OBS: the answer of the floor which gives the smallest answer even in the worst case!!!
    //O(k*n^2)
    public static int egg(int k, int n, int[][] t) {
        if(n==1 || n==0) return n;
        if(k==1) return n; // SINCE IN THE WORST CASE THE LAST FLOOR MAYBE THE ANSWER!!!
        if(t[k][n]!=-1) return t[k][n];
        //in the worst case if we, start dropping from a floor and keep moving up till it breaks and take the minimum of these cases as answer
        int ans=Integer.MAX_VALUE;
        for(int i=1;i<=n;i++){
            //two possibilities: breaks on the current floor or doesn't
            if(t[k-1][i-1]==-1)
                t[k-1][i-1] = egg(k-1, i-1, t);
            if(t[k][n-i]==-1)
                t[k][n-i] = egg(k, n-i, t);
            ans = Math.min(ans, Math.max(t[k-1][i-1], t[k][n-i]));
            //Math.max(superEggDrop(k-1, i-1), superEggDrop(k,n-i)));
            //this is because we need the min of the worst case ans(MAX!!)
        }
        return t[k][n] = ans+1;
    }
    static int eggDrop(int n, int k) 
	{
	    int t[][]=new int[n+1][k+1];
        for(int i=1;i<=n;i++)
            for(int j=1;j<=k;j++)
                t[i][j]=-1;
            
        return egg(n,k,t);
	}
}