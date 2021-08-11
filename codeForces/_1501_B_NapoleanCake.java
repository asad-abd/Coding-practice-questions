import java.util.*;
import java.io.*;
// pretests passed
public class _1501_B_NapoleanCake//for codeForces
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
		int T,i;
		FastReader sc=new FastReader();
        T=sc.nextInt();
		for(int tt=0;tt<T;tt++){
			int n=sc.nextInt();
            int a[]=new int[n];
            int ans[]=new int[n];
            for(i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int res=0;
            for(i=n-1;i>=0;i--){
                res=Math.max(res,a[i]);
                ans[i]= res>0?1:0;
                res--;
            }
            for(i=0;i<n;i++){
                System.out.print(ans[i]+" ");
            }
            System.out.println();
        }
		
	}
}
