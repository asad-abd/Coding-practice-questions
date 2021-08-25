import java.util.*;
class _gfg_best_BS_Allocate_minimum_number_of_pages {
    static boolean isValid(int[] a, int n, int k, int max){
        int students=1, sum=0;
        //System.out.println("MAX: " + max);
        for(int i=0; i<n;i++){
            sum+=a[i];
            if(sum>max){
                students++;//give the overflow to the next student 
                sum=a[i];
                
            }
            if(a[i]>max || students>k){//1 indexed! - S.M. Done before
                //System.out.println(students+"   bloody false!!!");
                return false;
                
            }
        }
        //System.out.println(students+" , k: "+k);
        
        return true;
    }
    public static int findPages(int[]a,int n,int k)
    {
        if(k>n) return -1;//VVVVimp condition: WA on InterviewBit w/o this.
        int st=0,end=0,mid;
        for(int i=0;i<n;i++){
            st=Math.max(st,a[i]);
            end+=a[i];
        }
        int ans=-1;
        //st=0;
        while(st<=end){
            mid=st+(end-st)/2;
            if(isValid(a,n,k,mid)){
                //System.out.println(mid);
                ans=mid;
                end=mid-1;
            }
            else
                st=mid+1;
        }
        return ans;
    }
}
