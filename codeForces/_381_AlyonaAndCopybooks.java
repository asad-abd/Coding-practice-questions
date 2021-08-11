import java.util.*;
//Done: 2 mistakes made:
//1. Integer overflow not considered
//2. forgot one case (c+c+c) in k==1
// https://codeforces.com/blog/entry/48582
public class _381_AlyonaAndCopybooks {
    int IINF=Integer.MAX_VALUE;
	static long mod=1000000007;
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		long n=sc.nextLong();
        long a=sc.nextLong();
        long b=sc.nextLong();
        long c=sc.nextLong();
        long multiple=(int)Math.ceil((double)n/4.0);
        long diff=multiple*4-n;
        if(diff==1) 
            System.out.println(Math.min(Math.min(a,b+c), Math.min(c+c+c,3*b+c)));
        else if(diff==2)
            System.out.println(Math.min(Math.min(b,a+a), c+c));
        else if(diff==3)
            System.out.println(Math.min(Math.min(c,a+a+a), a+b));
        else
            System.out.println("0");
	}
}
