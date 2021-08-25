import java.util.*;
class _spoj_Aggressive_Cows{//submitted successfully.
    //make sure to keep the core problem statement in mind while making the isValid()
    //"The largest minimum distance" --- therefore 'mid' will be considered as the minimum gap!! in isValid()
    //the 'Largest' in "The largest minimum distance" will be taken care of by the Binary search!!
    //conclusion: first largest/smallest taken care by BS. second largest/smallest taken care by isValid()
    
    public static boolean isValid(int noOfCows, int[] stalls, long minGap){
        long i=0, lastPos=stalls[0];

        for(int j=1;j<stalls.length;j++){
            if(stalls[j]-lastPos<minGap){
                //consider more stalls
            }
            else{//stall[j]-lastPos >= minGap
                lastPos=stalls[j];
                i++;
            }
        }
        if((int)i<noOfCows-1)
            return false;
        return true;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int tt=sc.nextInt();
        for(int t=0;t<tt;t++){
            int n=sc.nextInt();
            int c=sc.nextInt();
            int stalls[]=new int[n];
            long st=0,end=0;
            for(int i=0;i<n;i++){
                stalls[i]=sc.nextInt();
                end+=stalls[i];
            }
            Arrays.sort(stalls);
            //BS for the maximum possible contiguous gap between two cows=> assign max stalls to each cows s.t.
            //the max distance to next cow is NOT MORE THAN ans (mid)
            long mid,ans=0;
            while(st<=end){
                mid=st+(end-st)/2;
                if(isValid(c, stalls, mid)){
                    ans=mid;
                    st=mid+1;
                }
                else
                    end=mid-1;
            }
            System.out.println(ans);
        }
    }
}