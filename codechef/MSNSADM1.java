import java.util.*;
import java.io.*;
class MSNSADM1//Code Chef august 2019 long challenge
{

	public static void main(String args[])
	{
		int n,t ;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			n=sc.nextInt();
			int a[]=new int[n];
			int b[]=new int[n];
			int score[]=new int[n];
			int maxScore=0;
			for(int j=0;j<n;j++)
			{
				a[j]=sc.nextInt();
				score[j]=a[j]*20;
			}
			
			for(int j=0;j<n;j++)
			{	
				b[j]=sc.nextInt();
				if(score[j]>=10*b[j])
					score[j]-=10*b[j];
				else
					score[j]=0;
				if(score[j]>maxScore)
					maxScore=score[j];
			}
			ans[i]=maxScore;
		}

		for(int i=0;i<t;i++)
		{
			System.out.println(ans[i]);
		}
	}
}