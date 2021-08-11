import java.util.*;
import java.lang.*;
import java.io.*;
 class COINS//Codechef practice-medium
{
	/*public static void main (String[] args) throws java.lang.Exception
	{
	    	Scanner sc=new Scanner(System.in);
		while(sc.hasNextInt()){
		  System.out.println(f(sc.nextInt()));
		}
	}
	public static long f(int n){
	    if(n<12){
	        return n;
	    }
	    return Math.max(n,f(n/2)+f(n/3)+f(n/4));
	}*/
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		while(sc.hasNext()){
			ArrayList<Integer> arr=new ArrayList<Integer>();
			int n=sc.nextInt();
			arr.add(n);
			
			for(int i=0;i<arr.size();i++){
				n=arr.get(i);
				if((int)(n/2)+(int)(n/3)+(int)(n/4)>n){
				//System.out.println(n+"  and coins sum = "+(int)(n/2)+(int)(n/3)+(int)(n/4)+"\n");
					arr.remove(i);
					arr.add(i,(int)(n/2));
					arr.add(i,(int)(n/3));
					arr.add(i,(int)(n/4));
					i=i-1;
				}	
				
			}
			long sum=0;
				for(int j=0;j<arr.size();j++)
					sum+=arr.get(j);
					System.out.println(sum+"\t");
		}
	}
}