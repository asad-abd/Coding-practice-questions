import java.util.*;
import java.io.*;
//
public class AnadiAndDomino//for codeForces
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
		long n,k;
		FastReader sc=new FastReader();
		int n=sc.nextInt();
		int m=sc.nextInt();
		int a[]=new int[n];
		int b[]=new int[n];
		for(int i=0;i<m;i++){
			a[i]=sc.nextInt();
			b[i]=sc.nextInt();
		}
		System.out.println(ans);
	}
}
