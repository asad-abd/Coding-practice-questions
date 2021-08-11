import java.util.*;
import java.io.*;
//
public class a1337string//for codeForces E-70 C
{

	public static void main(String args[])
	{
		int n,k,y,q=1,finalq=0,min,a=1,b=1;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		String ans[]=new String[n];
		for(int p=0;p<n;p++)
		{
			String s="";
			k=sc.nextInt();
			min=k;
			int x;
			for(x=1;x<=k;x++)
			{
				if(k%x==0)
				{
					y=k/x;
					//y is acceptable only if sqrt(8y+1) is odd
					double sq=Math.sqrt(8*y+1);
					if(sq==Math.ceil(sq))
					{
						int check=(int)sq;
						if(check%2==1)
						{
							q=(1+(int)Math.sqrt(8*y+1))/2;
							if(Math.abs((q*(q-1))/2-x)<min  )
							{
								min=Math.abs((q*(q-1))/2-x);
								finalq=q;
							}
						}

					}

				}
			}
			x=k/(q*(q-1));
			int tempa=1,tempb=1,temin=x;
			for(int i=1;i*i<=x;i++)
			{
				if(x%i==0)
				{
					tempa=i;tempb=x/i;
					if(tempb-tempa<min)
					{
						a=tempa;
						b=tempb;
						min=b-a;
					}
				}
			}
			for(int i=1;i<=a;i++)
				s+="1";
			for(int i=1;i<=q;i++)
				s+="3";
			for(int i=1;i<=b;i++)
				s+="7";
			ans[p]=s;
		}

		for(int p=0;p<n;p++)
		{
			System.out.println(ans[p]);
		}
	}
}
			