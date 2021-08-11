import java.util.*;
import java.io.*;
//
public class EqualizePrices//for codeForces #590 (div3) A
{
	static long mod=1000000007;
	static void pnl(Object o){
		System.out.println(o);
	} 
	static void pn(Object o){
		System.out.print(o+" ");
	}
	static class FastReader{
		BufferedReader br;
		StringTokenizer st;
		public FastReader(){
			br=new BufferedReader(new InputStreamReader(System.in));
		}

		String next(){
			while(st==null || !st.hasMoreElements()){
				try{
					st=new StringTokenizer(br.readLine());
				}
				catch(IOException e){
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}
		int nextInt(){ 
            return Integer.parseInt(next()); 
        }
        long nextLong(){ 
            return Long.parseLong(next()); 
        } 
  
        double nextDouble(){ 
            return Double.parseDouble(next()); 
        }
        String nextLine(){ 
            String str = ""; 
            try
            { 
                str = br.readLine(); 
            } 
            catch (IOException e) 
            { 
                e.printStackTrace(); 
            } 
            return str; 
        } 
	}
	public static void main(String args[])
	{
		int n,t;
		FastReader sc=new FastReader();
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++){
			n=sc.nextInt();
			int a[]=new int[n];
			long sum=0;
			for(int i=0;i<n;i++){
				a[i]=sc.nextInt();
				sum+=a[i];
			}
			if(sum%n==0)
				ans[p]=(int)sum/n;
			else
				ans[p]=(int)sum/n +1;

		}
		for(int i=0;i<t;i++)
			System.out.println(ans[i]);
	}
}