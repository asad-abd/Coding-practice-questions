import java.util.*;
import java.io.*;
class RPD//for CodeChef
{

	public static void main(String args[])
	{
		int n,t,temp=0,temp1,max ;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			n=sc.nextInt();
			int a[]=new int[n];
			for(int k=0;k<n;k++)
				a[k]=sc.nextInt();
			max=0;
			for(int k=0;k<n;k++)
				for(int j=k+1;j<n;j++)		
				{

					temp1=0;
					temp=a[k]*a[j];
					while(temp>0)
					{
						temp1+=(temp%10);
						temp/=10;
					}
					if(temp1>max)
						max=temp1;
				}	
			ans[i]=max;
		}

		for(int i=0;i<t;i++)
		{
			System.out.println(ans[i]);
		}
	}
}