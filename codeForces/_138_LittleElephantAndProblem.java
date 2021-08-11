import java.util.*;
import java.io.*;
// Done
public class _138_LittleElephantAndProblem//for codeForces
{
	int IINF=Integer.MAX_VALUE;
	static long mod=1000000007;
	
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++)
            arr[i]=sc.nextInt();
        //System.out.println();
        int sorted[]=Arrays.copyOf(arr,arr.length);
        int count=0;
        Arrays.sort(sorted);
		for(int i=0; i<n; i++){
            if(arr[i]!=sorted[i])
                count++;
            //if count>2. someone meddled
            if(count>2)
                break;
        }
        if(count>2)
            System.out.println("NO");
        else
            System.out.println("YES");
	}
}

