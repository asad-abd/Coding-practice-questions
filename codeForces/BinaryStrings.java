import java.util.*;
import java.io.*;
//Done :)
public class BinaryStrings//for Codeforces E70-A
{

	public static void main(String args[])
	{
		int t ;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++)
		{
			String x,y;
			x=sc.next();
			y=sc.next();
			int lastx=0;
			int lasty=0;
			//find last index of 1 in y
			for(int i=y.length()-1;i>=0;i--)
			{
				lasty++;
				if(y.charAt(i)=='1')
				{
					break;
				}	
			}
			
			for(int i=x.length()-1;i>=0;i--)
			{
				lastx++;
				if(x.charAt(i)=='1'&&lastx>=lasty)
				{
					break;
				}	
			}
			ans[p]=lastx-lasty;

						
		}

		for(int p=0;p<t;p++)
		{
			System.out.println(ans[p]);
		}
	}
}