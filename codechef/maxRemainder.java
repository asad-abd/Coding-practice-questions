import java.util.*;
import java.io.*;
class maxRemainder//for CodeChef
{

	public static void main(String args[])throws IOException
	{
		int n,max=1;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int[n];
		
		
		for(int i=0;i<n;i++)
		{
			a[i]=sc.nextInt();
			
		}
		for(int i=0;i<n;i++)
		{
			for(int j=0;j<n;j++)
			{
				if(a[i]%a[j]>max)
					max=a[i]%a[j];
				
			}
			
		}

		System.out.println(max);
		
	}
}