import java.util.*;
import java.io.*;
// Done (nice Binary search question)
public class _153_3_points_on_a_line {
    int IINF=Integer.MAX_VALUE;
	static long mod=1000000007;
	public static int Bsearch(int arr[], int st, int end, int d){
        int mid;
        int index=-1;
        int valStart=arr[st];
        if(arr[end]-arr[st]<=d)
            return end;
        while(st<=end){
            mid= st + (end-st)/2;
            if(arr[mid]-valStart<=d){
                index=mid;
                st=mid+1;
            }
            else{
                end=mid-1;
            }
        }
        return index;
    }
	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int d=sc.nextInt();
        int arr[]=new int[n];
        for(int i=0; i<n; i++)
            arr[i]=sc.nextInt();
        //System.out.println();
        long count=0;
		for(int i=0; i<n-2; i++){
            int j=Bsearch(arr, i, n-1, d);
            if(j==-1) continue;
            //for each 'i', we've found the index of the largest num that satisfies our prop
            //we have k=j-i numbers AFTER i (including jth one).
            //we can choose any 2 of them. kC2 = k*(k-1)/2
            long k=j-i;
            count+=k*(k-1)/2;
        }
        System.out.println(count);
	}
}
