import java.util.*;
import java.io.*;
import java.util.*;
import java.io.*;
class ZOMCAV//for CodeChef august long contest 2019
{

	public static void main(String args[])
	{
		int n,t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++)
		{
			n=sc.nextInt();
			int flag=1;
			int h[]=new int[n+1];
			int c[]=new int[n+1];
			int start[]=new int[n+1];
			int end[]=new int[n+1];
			int opBraces[]=new int[n+1];
			int clBraces[]=new int[n+1];
			long rlevel[]=new long[n+1];
			for(int i=1;i<=n;i++)
			{
				c[i]=sc.nextInt();
				start[i]=i-c[i]>=1?(i-c[i]):1;
				end[i]=i+c[i]<=n?(i+c[i]):n;
				
			}
			for(int i=1;i<=n;i++)
				h[i]=sc.nextInt();
			for(int i=1;i<=n;i++)
			{
				opBraces[start[i]]++;
				clBraces[end[i]]++;
			}
			
			int temp=0;
			for(int i=1;i<=n;i++)
			{
				temp+=opBraces[i];
				rlevel[i]=temp;
				temp-=clBraces[i];
			}
			Arrays.sort(rlevel);
			Arrays.sort(h);
			for(int i=1;i<=n;i++)
			{
				if(h[i]!=rlevel[i])
				{
					flag=0;
					break;
				}	
			}
			ans[p]=flag;
		}

		for(int p=0;p<t;p++)
		{
			if(ans[p]==1)
				System.out.println("YES");
			else
				System.out.println("NO");
		}
	}
}

/*
			for(int i=1;i<=n;i++)
			{
				c=sc.nextInt();
				int start=i-c>=1?(i-c):1;
				int end=i+c<=n?(i+c):n;
				for(int j=start;j<=end;j++)
					rlevel[j]++;
			}
*/