class _gfg_IMP_Mobile_numeric_keypad {
    //my thinking fot below one: try finding how many times 'i' appeared in the last digit of the final numbers
    //i can only be produced from its neighbors. so think, which numbers from the second last place could have produced i 
    //write the keypad for getting the dp relation.
    public long getCount(int N)
	{
	    long dp[][]=new long[N+1][10];
	    //dp[i][j] stores the number of occurences of digit i at the jth digit
	    
		for(int i=0;i<10;i++){
		    dp[1][i]=1;
		}
		for(int i=2;i<=N;i++){
		    dp[i][0]=dp[i-1][0]+dp[i-1][8];//0 will be occuring in the last place as many times as he occurences of 0 and 8 in the previous places
		    dp[i][1]=dp[i-1][1]+dp[i-1][2]+dp[i-1][4];
		    dp[i][2]=dp[i-1][1]+dp[i-1][2]+dp[i-1][3]+dp[i-1][5];
		    dp[i][3]=dp[i-1][2]+dp[i-1][3]+dp[i-1][6];
		    dp[i][4]=dp[i-1][1]+dp[i-1][4]+dp[i-1][5]+dp[i-1][7];
		    dp[i][5]=dp[i-1][2]+dp[i-1][4]+dp[i-1][5]+dp[i-1][6]+dp[i-1][8];
		    dp[i][6]=dp[i-1][3]+dp[i-1][5]+dp[i-1][6]+dp[i-1][9];
		    dp[i][7]=dp[i-1][4]+dp[i-1][8]+dp[i-1][7];
		    dp[i][8]=dp[i-1][5]+dp[i-1][7]+dp[i-1][9]+dp[i-1][0]+dp[i-1][8];
		    dp[i][9]=dp[i-1][6]+dp[i-1][8]+dp[i-1][9];
		}
		long ans=0;
		for(int i=0;i<10;i++){
		    ans+=dp[N][i];
		}
		return ans;
	}
}
