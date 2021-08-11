import java.util.*;
import java.io.*;
//easy question of quadratic eqn
public class SportsMafia//for codeForces
{

	public static void main(String args[])
	{
		long n,k;
		Scanner sc=new Scanner(System.in);
		n=sc.nextLong();
		k=sc.nextLong();
		long ans=(long)(3+2*n-Math.sqrt(8*k+8*n+9))/2;
		if(ans<0)
			ans=(long)(3+2*n+Math.sqrt(8*k+8*n+9))/2;
		System.out.println(ans);
	}
}