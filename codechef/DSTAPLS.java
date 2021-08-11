import java.util.*;
import java.io.*;
class DSTAPLS//for CodeChef august long challenge 2019
{

	public static void main(String args[])
	{
		int t ;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		boolean ans[]=new boolean[t];
		long n,k,a;
		for(int p=0;p<t;p++)
		{
			n=sc.nextLong();
			k=sc.nextLong();
			a=n/k;
			if(a%k==0)
				ans[p]=true;
			else
				ans[p]=false;
		}

		for(int i=0;i<t;i++)
		{
			if(ans[i]==true)
				System.out.println("NO");
			else
				System.out.println("YES");
		}
	}
}