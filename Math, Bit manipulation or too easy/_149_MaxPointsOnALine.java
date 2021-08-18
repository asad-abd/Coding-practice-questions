class _149_MaxPointsOnALine {

    //code has a few errors specially with duplicate points.
    //ERR: 
    int gcd(int a, int b){
        if(a<b){
            int temp=a;
            a=b;
            b=temp;
        }
        if(b==0) return a;
        return gcd(b, a%b);
    }
    public int maxPoints(int[][] points) {
        int n=points.length;
        if(n==0)
            return 0;
        int max=1;
        for(int i=0;i<n;i++){
            //ith point is our hinge, i.e., we use this to measure the slopes
            HashMap<String,Integer> slope = new HashMap<>();
            HashMap<String,Integer> points = new HashMap<>();
            int duplicate=0;
            for(int j=i+1; j<n; j++){
                //if duplicate point. simply add the point to points hset and increment 

                int dy=(points[j][1]-points[i][1]);
                int dx=(points[j][0]-points[i][0]);
                //System.out.println(dy+" / "+dx);
                    
                String mslope;
                if(dx==0 && dy==0){ //same point
                    duplicate++;
                    continue;
                }
                else if(dx==0){//x=k line, slope Integer.MAX_VALUE(I as string)
                    mslope="I,I";
                }
                else if(dy==0){
                    mslope="0,0";
                }
                else if(dy>0 && dx>0 || dy<0 && dx<0){
                    int hcf=gcd(Math.abs(dy),Math.abs(dx));
                    dy=dy/hcf;
                    dx=dx/hcf;
                    mslope=""+(Math.abs(dy))+","+(Math.abs(dx));
                }
                else {//if(dy>0 && dx<0 || dy<0 && dx>0){
                    int hcf=gcd(Math.abs(dy),Math.abs(dx));
                    dy=dy/hcf;
                    dx=dx/hcf;
                    mslope=""+(-Math.abs(dy))+","+(Math.abs(dx));
                }
                //System.out.println(i+" - "+slope);
                slope.put(mslope, slope.getOrDefault(mslope,1)+1+duplicate);
                max=Math.max(max,slope.get(mslope));
            }
        }
        return max;
    }
}
