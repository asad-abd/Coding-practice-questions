import java.util.*;
import java.io.*;
//
public class _1493_A_Anti_knapsack//for codeForces
{
	int IINF=Integer.MAX_VALUE;
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
		int T;
		FastReader sc=new FastReader();
        T=sc.nextInt();
		for(int tt=0;tt<T;tt++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            boolean ban[]=new boolean[n+1];
			//System.out.println(n-(k/2)-1);
			int count=0;
            for(int i=(int)Math.ceil((double)k/2);i<=n;i++){
				if(i!=k){
					count++;
                	//System.out.print(i+" ");
				}
            }
            System.out.println(count);
			for(int i=(int)Math.ceil((double)k/2);i<=n;i++){
				if(i!=k){
					System.out.print(i+" ");
				}
            }
            System.out.println();
        }
		//
	}
}
