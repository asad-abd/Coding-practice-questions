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
    // THIS IS INCORRECT eg: 1->2->3. below code returns 3 but 1 doesn't trust 3!!(4-2-21)
    public int findJudge(int N, int[][] trust) {
        int outDegree[] = new int[N];
        for(int pair[] : trust){
            outDegree[pair[0]-1]++;
        }
        for(int i=0;i<N;i++ ){
            if( outDegree[i]==0)
                return i+1;
        }
        return -1;
    }
}
