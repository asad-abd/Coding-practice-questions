import java.util.*;
import java.io.*;
public class DecimalString//for Codeforces E70-B
{

	public static void main(String args[])
	{
		int diff=0;
		int grid[][]=new int[10][10];
		int lastDigits[][]=new int[10][10];
		int minNumOfABforDiff[][][]=new int[10][10][10];
		String s;
		Scanner sc=new Scanner(System.in);
		s=sc.next();
		for(int i=1;i<=9;i++)
		{
			lastDigits[i][0]=0;//i times 0
			for(int j=1;j<=9;j++)
			{
				lastDigits[i][j]=(lastDigits[i][j-1]+i)%10;
			}
				
		}
		/*for(int i=1;i<=9;i++)
		{
			
			for(int j=0;j<=9;j++)
			{
				System.out.print(lastDigits[i][j]+"  ");
			}
			System.out.println();
		}*/
		for(int i=0;i<10;i++)
		{	
			for(int j=i;j<10;j++)
			{
				for(diff=0;diff<10;diff++)
				{
					if(diff%2==1 && i%2==0 && j%2==0)
					{
						minNumOfABforDiff[diff][i][j]=-1;
						minNumOfABforDiff[diff][j][i]=-1;					
					}
					else
					{
						int min=18;
						for(int p=0;p<=9;p++)
						{
							for(int q=0;q<=9;q++)
							{	
								min=18;
								if((lastDigits[i][p]+lastDigits[j][q])%10==diff && p+q<min)
								{
									min=p+q;
									minNumOfABforDiff[diff][i][j]=min;
									minNumOfABforDiff[diff][j][i]=min;


								}
							}
						}
					}
				}
			}
		}

		for(int p=0;p<s.length()-1;p++)
		{	
			for(int i=0;i<10;i++)
			{	

				for(int j=i;j<10;j++)
				{
					if(s.charAt(p)-'0'>s.charAt(p+1)-'0')
						diff=10+s.charAt(p+1)-s.charAt(p);
					else
						diff=s.charAt(p+1)-s.charAt(p);
					if(minNumOfABforDiff[diff][i][j]==-1)
					{
						grid[i][j]=-1;
						grid[j][i]=-1; 
						break;
					}
					else
					{
						grid[i][j]+=minNumOfABforDiff[diff][i][j];
						grid[j][i]+=minNumOfABforDiff[diff][j][i];
					}

				}
			}
		}

		for(int p=0;p<10;p++)
		{
			for(int q=0;q<10;q++)
				System.out.print(grid[p][q]+" ");
			System.out.println();
		}
	}
}