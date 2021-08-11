import java.util.*;
public class _ed_104_Arena {
    public static void main(String args[])
	{
		int T;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
        for(int t=0;t<T;t++){
            int n=sc.nextInt();
            int min=Integer.MAX_VALUE;
            int arr[] = new int[n];
            int count=0;
            for(int i=0;i<n;i++){
                arr[i]=sc.nextInt();
                min=Math.min(arr[i], min);
            }
            for(int i=0;i<n;i++)
                if(arr[i]>min)
                    count++;
            System.out.println(count);
        }
		
	}
}
