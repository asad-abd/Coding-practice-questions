import java.util.*;
// 
public class _34_Reconnaissance2 {
    public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        int diff=Integer.MAX_VALUE;
        int index=0;
        for(int i=0;i<n;i++){
            if(Math.abs(arr[i]-arr[(i+1)%n])<diff){
                diff=Math.abs(arr[i]-arr[(i+1)%n]);
                index=i;
            }
        }
        
        System.out.println((index+1) + " " + ((index+1)%n+1));
	}
}


