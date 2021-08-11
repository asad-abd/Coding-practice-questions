import java.util.*;
import java.util.Comparator;
import java.util.Arrays;
import java.io.*;
class KS1//for CodeChef august long challenge 2019
{
	public static void main(String args[])
	{
		int n,t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++)
		{
			n=sc.nextInt();
			int a[]=new int[n+1];
			int x[]=new int[n+1];
			int xoriTok;
			for(int i=1;i<=n;i++)
				a[i]=sc.nextInt();
			for(int i=1;i<=n;i++)
				x[i]=a[i]^x[i-1];
			for(int i=1;i<=n;i++)
				System.out.print(jx[i]+"\t")j;
			for(int k=2;k<=n;k++)
			{
				for(int i=1;i<k;i++)
				{
					xoriTok=x[k]^x[i-1];
					if(xoriTok==0)
						ans[p]+=(k-i);
					

				}	
			}

			
		}

		for(int p=0;p<t;p++)
		{
			System.out.println(ans[p]);
		}
	}
}
/* a little faster but still 50%
public static void main(String args[])
	{
		int n,t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++)
		{
			n=sc.nextInt();
			int a[]=new int[n+1];
			int x[]=new int[n+1];
			int xoriTok;
			for(int i=1;i<=n;i++)
				a[i]=sc.nextInt();
			for(int i=1;i<=n;i++)
				x[i]=a[i]^x[i-1];
			
			for(int k=2;k<=n;k++)
			{
				for(int i=1;i<k;i++)
				{
					xoriTok=x[k]^x[i-1];
					if(xoriTok==0)
						ans[p]+=(k-i);
					

				}	
			}

			
		}

		for(int p=0;p<t;p++)
		{
			System.out.println(ans[p]);
		}
	}
*/

/*50% one
			import java.util.*;
import java.io.*;
class KS1//for CodeChef august long challenge 2019
{

	public static void main(String args[])
	{
		int n,t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++)
		{
			n=sc.nextInt();
			int a[]=new int[n+1];
			int x[]=new int[n+1];
			int xorl=0,xorr=0;
			for(int i=1;i<=n;i++)
				a[i]=sc.nextInt();
			for(int i=1;i<=n;i++)
				x[i]=a[i]^x[i-1];
			for(int k=2;k<=n;k++)
			{
				for(int i=1;i<k;i++)
				{
					
					for(int j=i+1;j<=k;j++)
					{
						xorl=x[j-1]^x[i-1];
						xorr=x[k]^x[j-1];
						if(xorl==xorr)
							ans[p]++;
					}

				}	
			}

			
		}

		for(int p=0;p<t;p++)
		{
			System.out.println(ans[p]);
		}
	}
}*/
/*0%-WA
class KS1//for CodeChef august long challenge 2019
{
	public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr,new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    } 
	public static void main(String args[])
	{
		int n,t;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++)
		{
			n=sc.nextInt();
			int a[]=new int[n+1];
			int x[][]=new int[n+1][2];
			int tempx[][]=new int[n][2];
			int xoriTok;
			for(int i=1;i<=n;i++)
				a[i]=sc.nextInt();
			for(int i=1;i<=n;i++)
			{	
				x[i][0]=a[i]^x[i-1][0];
				x[i][1]=i;
			}
			for(int i=1;i<=n;i++)
			{	
				tempx[i-1][0]=x[i][0];
				tempx[i-1][1]=x[i][1];
				
			}
			//System.out.println(Arrays.deepToString(x));
			sortbyColumn(tempx, 0);
			for(int i=1;i<=n;i++)
			{	
				x[i][0]=tempx[i-1][0];
				x[i][1]=tempx[i-1][1];
				
			}
			//after sorting 2d array based on xor till i
			for(int i=1;i<=n;i++)
			{	
				if(x[i][0]==0 &&x[i][1]>1)
				    if(x[1!=0)
						ans[p]+=(x[i][1]-1);
			for(int i=1;i<=n;i++)
			{
				int start=i,end=i;
				while(i<n)
				{
					
					if(x[i][0]==x[i+1][0])//equal
					{
						end=i+1;
						i++;
					}
					else
						break;
					
				}
				//if(i==n&& (x[i][0]==0 &&x[i][1]>1))
				//		ans[p]+=(x[i][1]-1);
				for(int j=start;j<=end;j++)
				{
					for(int k=j+1;k<=end;k++)
						if((x[j][1]-x[k][1]-1)>0)
						ans[p]+=(x[j][1]-x[k][1]-1);

				}				

			}
			//System.out.println(Arrays.deepToString(x));
		}

		for(int p=0;p<t;p++)
		{
			System.out.println(ans[p]);
		}
	}
}
*/