/*
https://www.codechef.com/JUNE19B/problems/PROXYC

In a certain course, there is exactly one lesson per day over the course of D days (numbered 1 through D). You are given a string S with length D describing the lessons Chef attended — for each valid i, the i-th character of this string is either 'A' if Chef was absent on day i or 'P' if Chef was actually present on day i.

For each day d when Chef is absent, one of Chef's friends can mark him as present by proxy on this day only if he was present (if he was really present, not just marked as present) on at least one of the previous two days, i.e. days d−1 and d−2, and on at least one of the following two days, i.e. days d+1 and d+2. However, it is impossible to mark him as present by proxy on the first two days and the last two days.
*/
import java.util.*;
import java.io.*;
class proxy//for CodeChef
{

	public static void main(String args[]) throws IOException
	{
		int t,D,countP,reqP,possibleP;
		String s;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0,j=0;i<t;i++)
		{
			countP=0;
			possibleP=0;
			D=sc.nextInt();
			s=sc.nextLine();
			reqP=(int)Math.ceil((0.75*D));
			for(j=0;j<D-2;j++)
			{
				char c=s.charAt(j);
				if(c=='P')
					countP++;
				if(countP>=reqP)
				{	
					ans[i]=0;
					break;
				}
				if(j>=2&& j<=D-3)
				{
					if(c=='A')
					{
						if(s.charAt(j-1)=='P' && s.charAt(j-2)=='P'&&((s.charAt(j+1)=='P' && s.charAt(j+2)=='P')||(s.charAt(j+1)=='A' && s.charAt(j+2)=='P')||(s.charAt(j+1)=='P' && s.charAt(j+2)=='A')))
						{
							possibleP++;
						}
					}
					else
						countP++;

				}
				else 
				{
					if(s.charAt(j)=='P')
						countP++;
					
				}
			}
			if(s.charAt(j++)=='P')
				countP++;
			if(s.charAt(j)=='P')
				countP++;
			if(possibleP>=reqP)
			{
				ans[i]=reqP;
			}
			else
				ans[i]=-1;

		}

		for(int i=0;i<t;i++)
		{
			System.out.println(ans[i]);
		}
	}
}