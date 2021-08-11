import java.util.*;
import java.io.*;
class SFRV//for CodeChef
{
	public static void main(String args[])
	{
		long n,t ;
		Scanner sc=new Scanner(System.in);
		t=sc.nextLong();
		long ans[]=new long[(int)t];
		long s=0;
		for(long i=0;i<t;i++)
		{
			n=sc.nextLong();
			long a[]=new long[(int)n];
			for(long k=0;k<n;k++)
				a[(int)k]=sc.nextLong();
			s=0;
			//now, rearrange
			for(long k=n-1;k>0;k--)
			{
				if(a[(int)k]<a[(int)k-1])
				{
					long temp=a[(int)k];
					a[(int)k]=a[(int)k-1];
					a[(int)k-1]=temp;
				}
			}
			for(long k=0;k<n;k++)
			{
				s+=(k+1)*a[(int)k];
			}
			ans[(int)i]=s;

		}

		for(long i=0;i<t;i++)
		{
			System.out.println(ans[(int)i]);
		}
	}
}