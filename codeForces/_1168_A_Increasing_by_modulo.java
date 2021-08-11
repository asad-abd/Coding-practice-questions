import java.util.*;
//Mind boggling approach - DONE
public class _1168_A_Increasing_by_modulo {
    //observe one thing => the answer is the MAX BUDGET REQUIRED FOR A SINGLE INDEX 
    //(since i can pick any number of random indices at any time)

    // if prev <= (a[i]) 
    //      if it is possible using a given budget to change a[i] to prev, we'll do it (prev remains the same)
    //      if it is out of budget, simply say that for the next number prev = a[i] 
    // else if prev >= a[i]
    //      only way is to increase a[i] to prev by spending (prev-a[i])
    //      if it isn't in our budget, return false.
    public static boolean validate(int a[], int budget, int m){
        int prev=0;
        int k;
        for(int i=0;i<a.length;i++){
            if(prev<=a[i]){
                //this case will NEVER return false, but WE CAN TRY to optimize a[i] for any RHS a[j] (if in budget)

                //I want some 'k' s.t. (k+a[i])%m = prev.
                //we know, that m<=a[i]+k (a necessary requirement)
                //and we also don't want to unnecessarily add more than require to it to overflow m
                //so,     m<=a[i]+k <=2m-1. then, to bring a[i]+k in range, subtract m on all sides
                //   0 <= a[i]+k-m <= m-1.   since we want a[i]+k-m = prev. k=m+prev-a[i];
                k=m + prev-a[i];
                //check if k is in budget. If so, prev remains same, else prev becomes a[i].
                if(k>budget) prev=a[i];
                //else prev remains same because we equated a[i] with its prev
            }
            if(prev>a[i]){
                //this case will return false if prev-a[i]>budget
                if(prev-a[i]>budget) return false;
                //else prev is same because we incremented a[i] to be prev
            }
        }
        return true;
    }
    int IINF=Integer.MAX_VALUE;
	static long mod=1000000007;
    public static void main(String args[])
	{
		int T;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int m=sc.nextInt();
        int a[]=new int[n];
        for(int i=0; i<n; i++)
            a[i]=sc.nextInt();
        int st=0, end=m-1, mid;
        //SMC done (end != n-1!!)
        int ans=m;
        while(st<=end){
            mid= st + (end-st)/2;
            
            if(validate(a, mid, m)){
                ans=mid;
                end=mid-1;
            }
            else{
                st=mid+1;
            }
        }
        System.out.println(ans);
        
		
	}
}
