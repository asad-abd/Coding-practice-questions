/*Easy question but with a "catch" for java:
array in line number 24 doesn't work with n instead of S.length.- some type of runtime problem
*/
import java.util.*;
import java.io.*;
class playingWithStrings//for CodeChef
{

	public static void main(String args[])
	{
		int n,t,countS=0,countR=0 ;
		String S,R;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			n=0;
			n=sc.nextInt();
			S=sc.next();
			R=sc.next();
			//check if S and R have equal number of 0s and 1s
			for(int k=0;k<S.length();k++)//can be optimised
			{
				countS+=(S.charAt(k)-'0');
				countR+=(R.charAt(k)-'0');
			}
			if(countS!=countR)
			{
				ans[i]=0;//0==no
				countS=0;
				countR=0;
				
			}
			else
			{
				ans[i]=1;
				countS=0;
				countR=0;
				
			}

		}

		for(int i=0;i<t;i++)
		{
			if(ans[i]==0)
			System.out.println("NO");
		else
			System.out.println("YES");
		}
	}
}