class killingCircle{
    public static void whoIsAlive(int n){
        //O(n^2)
        int i=0,j=1;
        boolean killed[]=new boolean[n];
        int alive=n;
        boolean killCurrent=false;
       
        while(alive>1){
            if(!killed[i]){
                if(killCurrent){
                    killed[i]=true;
                    alive--;
                }
                killCurrent = !killCurrent;
            }
            i++;
            i=i%n;
        }
        for(i=0;i<n;i++){
            if(!killed[i])
                System.out.println("O(n*n) : "+(i+1));
        }

    }
    public static void whoIsAliveQuick(int n){
        //O(nlogn)
        int i=0,j=1;
        boolean killed[]=new boolean[n];
        int alive=n;
        boolean killCurrent=false;
        
        int cuts;
        while(alive>1){
            cuts=(alive+1)/2;

            while(cuts>0){
                if(!killed[i]){
                    if(killCurrent){
                        killed[i]=true;
                        alive--;
                        cuts--;
                    }
                    killCurrent = !killCurrent;
                }
                i=i+j;
                i=i%n;
            }
            j=j*2;
            
        }
        for(i=0;i<n;i++){
            if(!killed[i])
                System.out.println("O(nlogn) : "+(i+1));
        }
    }
    public static void printRunningTime(long start, long end){
        long execution = (end - start)/1000;
        System.out.println("Execution time: " + execution + " microseconds");
    }
    public static void main(String args[]){
        //change n here
        int n=100;
        long start,end;
        
        //O(n*n)
        start = System.nanoTime();
        whoIsAlive(n);
        end = System.nanoTime();
        printRunningTime(start,end);
        
        //O(n*log(n))
        start = System.nanoTime();
        whoIsAliveQuick(n);
        end = System.nanoTime();
        printRunningTime(start,end);
        
    }
}
