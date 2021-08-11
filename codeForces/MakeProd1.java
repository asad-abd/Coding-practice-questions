import java.util.*;
import java.io.*;
//done later :/
public class MakeProd1//for codeForces 580-b
{

	public static void main(String args[])
	{
		int n,i=0,countneg=0,count0=0;
		long num=0;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		long a[]=new long[n];
		for(i=0;i<n;i++)
			a[i]=sc.nextLong();
		for(i=0;i<n;i++){
			if(a[i]<0)
				countneg++;
			if(a[i]==0)
				count0++;
		}
		int temp=0;
		if(countneg%2==1){//neg count odd
			num+=count0;
			for(i=0;i<n;i++){
				if(a[i]<0&&countneg>1){
					num+=((a[i]+1)*(-1));
					countneg--;
				}
				else if(a[i]<0&&countneg<=1){
					if(count0>=1)
						num+=((a[i]+1)*(-1));
					else
						num+=((a[i]-1)*(-1));
				}
				else if(a[i]>0)
					num+=((a[i]-1));
			}		
			
		}
		
		else{//neg count even 
			num+=count0;
			//convert all neg to -1
			for(i=0;i<n;i++){
				if(a[i]<0){
					num+=((a[i]+1)*(-1));
				}
				
				else if(a[i]>0)
					num+=((a[i]-1));
			}	
		}

		System.out.println(num);
	}
}