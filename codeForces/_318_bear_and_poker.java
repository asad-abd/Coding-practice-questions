import java.util.*;
import java.io.*;
// Done. https://codeforces.com/blog/entry/20040
//each number is in the form of powers of prime numbers. 
//approach 1: Divide each number by 2 and 3 till until it becomes impossible. 
//If the remaining numbers are all same. YES. else no (i.e., they are product of different primes)
//approach 2: gcd=GCD of all. multiply with gcd only 2 and 3 and if you can recreate arr[i]. YES
public class _318_bear_and_poker {
    int IINF=Integer.MAX_VALUE;
	static long mod=1000000007;
	public static long GCD(long a, long b){
        if(a<b){
            long temp=a;
            a=b;
            b=temp;
        }
        if(b==0)
            return a;
        return GCD(b, a%b);
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int arr[]=new int[n];
        long prod=1;
        long gcd=1;
        for(int i=0; i<n; i++){
            arr[i]=sc.nextInt();
            
            gcd=GCD(gcd,arr[i]);
            prod*=arr[i];
        }
        //the above part is basically useless (approach 2 (not used))
        boolean possibleToWin=true;
        int x=arr[0];
        while(x%2==0 || x%3==0){
            if(x%3==0) x/=3;
            if(x%2==0) x/=2;
        }
        int rem=x;
        for(int i=1; i<n && possibleToWin; i++){
            x=arr[i];
            while(x%2==0 || x%3==0){
                if(x%3==0) x/=3;
                if(x%2==0) x/=2;
            }
            if(x!=rem){
                possibleToWin=false;
                break;
            }
                
        }
        if(possibleToWin)
            System.out.println("YES");
        else
            System.out.println("NO");
	}
}
