import java.util.*;
import java.io.*;
class CHEFDIL//Code Chef august 2019 long challenge
//chindi nikla question- if odd 1s then win else lose
{

	public static void main(String args[])
	{
		int t ;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			String s=sc.next();
			int count1=0;
			for(int j=0;j<s.length();j++)
			{
				if(s.charAt(j)=='1')
					count1++;
			}
			
			if(count1%2==0)
			ans[i]=0;//lose
			else
			ans[i]=1;//win
		}

		for(int i=0;i<t;i++)
		{
			if(ans[i]==0)
			System.out.println("LOSE");
			else
			System.out.println("WIN");

		}
	}
}