class _838_Push_Dominos {

    //works but do in dp manner later
    public String pushDominoes(String dominos) {
        char[] state=dominos.toCharArray();
        int n=state.length;
        //System.out.println(n);
        int simulDots=0;
        ArrayList<int[]> dots=new ArrayList<>();
        //store index of dots and length of simultaneous dots from there
        int i=0;
        while(i<n){
            if(state[i]!='.'){
                simulDots=0;
                i++;
            }
            else{
                int index=i;
                while(i<n && state[i]=='.'){
                    simulDots++;
                    i++;
                }
                //state[i] is now either l or r
                dots.add(new int[]{index, simulDots});
            }
        }
        //System.out.println(dots.size()+" "+dots.get(0).toString());
        for(i=0;i<dots.size();i++){
            int st=dots.get(i)[0];
            int len=dots.get(i)[1];
            int end=st+len-1;
            //check the indices before st and after end
            //if both same or one is out of bounds, all of st-end will be same
            //if left=l and right=r. no change
            //if left=r and right=l handle for even and odd case
            //System.out.println(state[st-1]+" , "+state[end+1]);
            if(st==0 && end==n-1) continue;
            else if(st==0){
                if(state[end+1]=='L')
                    for(int k=st;k<=end;k++)
                        state[k]='L';
            }
            else if(end==n-1 ){
                if(state[st-1]=='R'){
                    for(int k=st;k<=end;k++){
                        state[k]='R';
                    }
                }
            }
            else if(state[st-1]==state[end+1]){
                for(int k=st;k<=end;k++)
                    state[k]=state[st-1];
            }
            else if(state[st-1]=='R' && state[end+1]=='L'){
                if(len%2==0)
                for(int k=0;k<len/2;k++){
                    state[st+k]='R';
                    state[end-k]='L';
                }
                else
                for(int k=0;k<(len-1)/2;k++){
                    state[st+k]='R';
                    state[end-k]='L';
                }
            }
        }
        return String.valueOf(state);
    }
}
