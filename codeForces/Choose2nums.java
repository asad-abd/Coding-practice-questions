import java.util.*;
import java.io.*;
//submitted late due to silly ctrl c+v editing mistake :/
public class Choose2nums//for codeForces 580 a
{

	public static void main(String args[])
	{
		int ans=0,i=0,j=0;
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int a[]=new int[n];
		for(i=0;i<n;i++)
			a[i]=sc.nextInt();
		int m=sc.nextInt();
		int b[]=new int[m];
		for(i=0;i<m;i++)
			b[i]=sc.nextInt();
		int flag=1;
		for( i=0;i<n;i++){
			for(j=0;j<m;j++){
				flag=1;
				ans=a[i]+b[j];
				for(int k=0;k<n;k++){
					if(ans==a[k]){
						flag=0;
						break;
					}
				}
				if(flag!=0)
				for(int k=0;k<m;k++){
					if(ans==b[k]){
						flag=0;
						break;
					}
				}
				if(flag==1){
					System.out.println(a[i]+" "+b[j]);
					break;
				}
			}
			if(flag==1)
				break;

		}
				
			

	}
}