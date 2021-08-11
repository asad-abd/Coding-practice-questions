import java.util.*;
import java.io.*;
//done later, check other's codes not done
public class AlmostEqual//for codeForces 580c
{

	public static void main(String args[])
	{
		int n,maxleft,minleft;
		boolean yes=true;
		Scanner sc=new Scanner(System.in);
		n=sc.nextInt();
		int a[]=new int[2*n];
		maxleft=2*n;minleft=1;
		for(int i=0;i<n;i++){
			if(i%2==0){	
				a[i]=minleft;
				a[i+n]=minleft+1;
				minleft+=2;
			}
			else{
				a[i]=maxleft;
				a[i+n]=maxleft-1;
				maxleft-=2;
			}
		}
		for(int i=0;i<2*n;i++){
			//2 consecutive a[i]'s i+n indices shouldn't both increase or both decrease
			if((a[i]-a[(i+n)%(2*n)])*(a[(i+1)%(2*n)]-a[(i+1+n)%(2*n)])==1)
				yes=false;
		}
		if(yes==false)
			System.out.println("NO");
		else{
			System.out.println("YES");
			for(int i=0;i<2*n;i++){
				System.out.print(a[i]+" ");
			}
		}
	}
}