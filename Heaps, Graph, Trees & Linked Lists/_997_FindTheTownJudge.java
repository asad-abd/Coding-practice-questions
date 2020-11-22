class _997_FindTheTownJudge {
    public int findJudge(int N, int[][] trust) {
        // for the judge: in degree - out degree = N-1
        int countin[]=new int [N+1];
        int countout[]=new int [N+1];
        for(int i=1;i<=trust.length;i++){
            countin[trust[i-1][1]]++;
            countout[trust[i-1][0]]++;
        }
        int judge=0,noOfJudges=0;
        for(int i=1;i<=N;i++){
            if(countin[i]==N-1&&countout[i]==0){
                judge=i;
                noOfJudges++;
            }
        }
        if(noOfJudges!=1)
            return -1;
        else
            return judge;
    }
}
