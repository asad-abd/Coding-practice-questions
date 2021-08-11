import java.util.*;
import java.io.*;
class FlatLand
{

	public static void main(String args[])
	{
		int n,t,count=0,s,nearestS,temp;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			count=0;
			n=sc.nextInt();
			temp=n;
			while(temp>0)
			{
				s=(int)Math.sqrt(temp);
				nearestS=s*s;
				temp-=nearestS;
				count++;
			}
			
			ans[i]=count;
		}

		for(int i=0;i<t;i++)
		{
			System.out.println(ans[i]);
		}
	}
}