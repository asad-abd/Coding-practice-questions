import java.util.*;
import java.io.*;
//easily done :)
public class Pillars//for codeForces
{

	public static void main(String args[])
	{
		int n,maxi=0;
		boolean flag=true;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int[n];
		//find the greatest num
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			if(maxi>0)
				if(a[maxi]==a[i])
					flag=false;
			if(a[i]>a[maxi])
				maxi=i;
		}
		if(flag==true)
			for(int i=0;i<maxi-1;i++)
			{
				if(a[i]>=a[i+1])
				{	
					flag=false;
					break;
				}
			}
		if(flag==true)
			for(int i=maxi;i<n-1;i++)
			{
				if(a[i]<=a[i+1])
				{	
					flag=false;
					break;
				}
			}
		if(flag==true)
		System.out.println("YES");
		else
		System.out.println("NO");
	}
}