import java.util.*;
import java.io.*;
class ChefAndMean//for CodeChef
{

	public static void main(String args[])
	{
		int n,t,selectedCoin=0;
		Double mean=0.0,mean1=0.0;
		int A[]=new int[100000];
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			selectedCoin=0;
			mean=0.0;mean1=0.0;
			n=sc.nextInt();
			for(int k=0;k<n;k++)
			{
				A[k]=sc.nextInt();
				mean+=(double)A[k];
			}//input finished
			mean1=mean;
			mean/=n;
			for(int k=0;k<n;k++)
			{

				if(((mean1-(double)A[k])/(double)(n-1))==mean)
				{
					if(selectedCoin==0)
					{	
						selectedCoin=A[k];
						ans[i]=k+1;
					}
					else if(selectedCoin>A[k])
					{
						//swap
						selectedCoin=A[k];
						ans[i]=k+1;
					}

				}

			}
			if(selectedCoin==0)
				ans[i]=0;

		}

		for(int i=0;i<t;i++)
		{
			if(ans[i]==0)
			System.out.println("Impossible");
			else
			System.out.println(ans[i]);
		}
	}
}