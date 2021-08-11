import java.util.*;
import java.io.*;
public class SquareFilling//for codeForces E71B
{
	
	public static void main(String args[])
	{
		LinkedList<String> ll = new LinkedList<String>(); 
  		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a[][]=new int[n+1][m+1];
		int b[][]=new int[n+1][m+1];
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				a[i][j]=sc.nextInt();
			}
		}
		for(int i=1;i<n;i++){
				for(int j=1;j<m;j++){
					if(a[i][j]==1&&(a[i+1][j]==1&&a[i][j+1]==1&&a[i+1][j+1]==1)){
						ll.add(i+" "+j);
						b[i][j]=1;
						b[i+1][j]=1;
						b[i][j+1]=1;
						b[i+1][j+1]=1;
					}
				}
			}
			boolean bmadea=true;
		for(int i=1;i<=n;i++){
			for(int j=1;j<=m;j++){
				if(a[i][j]!=b[i][j]){
					bmadea=false;
					break;
				}
			}
		}
		if(bmadea==true){
			System.out.println(ll.size());
			while(ll.size()>0){
				System.out.println(ll.removeFirst());
			}
		}
		else
			System.out.println(-1);

	}
}