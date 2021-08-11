import java.util.*;
import java.io.*;
class newTablet
{

	public static void main(String args[])
	{
		int n,b,t,w,h,p,max=0;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			max=-1;
			n=sc.nextInt();
			b=sc.nextInt();
			for(int j=0;j<n;j++)
			{
				w=sc.nextInt();
				h=sc.nextInt();
				p=sc.nextInt();
				if(w*h>max && p<=b)
					max=w*h;

			}
			if(max==-1)
				ans[i]=-1;
			else
				ans[i]=max;
		}

		for(int i=0;i<t;i++)
		{
			
			if(ans[i]==-1)
				System.out.println("no tablet");
			else
				System.out.println(ans[i]);
		}
	}
}