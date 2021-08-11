import java.util.*;
import java.io.*;
//left incomplete-boring-july 2019 long challenge 
class PRTAGN//for CodeChef
{

	public static void main(String args[])
	{
		int q,t,x=0,k,lastindex=0;
		boolean found=false;
		
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		
		for(int i=0;i<t;i++)
		{
			int s[]=new int[10000000];
			q=sc.nextInt();
			int ans[][]=new int[q][2];
			lastindex=0;
			for(int j=0;j<q;j++)
			{
				//now 4 is entered(in eg:- 4 2 7)
				//check if the element is present in the set s
				//ans[q][0]=0;
				//ans[q][1]=0;
				x=sc.nextInt();
				lastindex=s.length;
				for( k=0;k<s.length;k++)
				{
					if(s[k]==x)//x matches with any one.
					{
						found=true;
						break;
					}

				}
				if(found==false)
				{
					s[lastindex++]=x;
					for( k=0;k<s.length;k++)
					{
						s[lastindex++]=x^s[k];//xor
					}
				}
				//now save E and O

				int count=0,temp=0;
				for( k=0;k<q;k++)
				{
					count=0;
					temp=s[k];
					while(temp>0)
					{
						if(temp%2==1)
							count++;
						temp/=2;
					}
					if(count%2==0)//even 1s
						ans[k][0]++;
					else
						ans[k][1]++;
				}
				System.out.println(ans[k][0]+" "+ans[k][1]);
			}
		}

		
	}
}