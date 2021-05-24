class _gfg_greedy_N_meetings_in_one_room {
    //easy. though the proof is still unclear. earliest finishing time. 
    public static int maxMeetings(int start[], int end[], int n)
    {
        int [][] a= new int[n][2];
        for(int i=0;i<n;i++){
            a[i][0]=start[i];
            a[i][1]=end[i];
        }
        Arrays.sort(a, (x,y)-> x[1]!=y[1]?Integer.compare(x[1],y[1]): Integer.compare(x[1]-x[0],y[1]-y[0]));
        
        int last=-1,count=0;
        for(int i=0;i<n;i++){
            if(last<a[i][0]){
                count++;
                last=a[i][1];
            }
        }
        return count;
    }
}
