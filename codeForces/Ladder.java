import java.util.*;
import java.io.*;
//done :)
public class Ladder//for codeForces
{

	public static void main(String args[])
	{
		int n=0,t;
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int j=0;j<t;j++)
		{
			n=sc.nextInt();
			int a[]=new int[n];
			int max1=0,max2=-1;
			for(int i=0;i<n;i++)
			{	
				a[i]=sc.nextInt();

			}
			for(int i=0;i<n;i++)
			{	
				if(a[i]>max2)
				{
					if(a[i]>max1)
					{
						max2=max1;
						max1=a[i];
					}
					else
						max2=a[i];
				}
			}
				
			int k=n-2;
			if(k>=max2)
				ans[j]=max2-1;
			else
				ans[j]=k;

		}
		for(int i=0;i<t;i++)
			{	
				System.out.println(ans[i]);

			}		
	}
}