//EXTREME SILLY MISTAKE CHANCE: case of else if("==" one). otherwise easy question
import java.util.*;
import java.io.*;
class MMAX//for CodeChef
{

	public static void main(String args[])
	{
		int n,t,kmod=0;
		String k;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			kmod=0;
			n=sc.nextInt();
			k=sc.next();
			//System.out.println(k/n);
			//calculating mod of k which is largeee
			for(int j=0;j<k.length();j++)
			{
				kmod=(kmod*10+(k.charAt(j)-'0')%n)%n;
			}

			if((n-kmod)<kmod)
				ans[i]=2*(n-kmod);
			else if((n-kmod)==kmod)
			    ans[i]=2*(n-kmod)-1;
			else 
				ans[i]=2*kmod;
			
			
		}

		for(int i=0;i<t;i++)
		{
			System.out.println(ans[i]);
		}
	}
}