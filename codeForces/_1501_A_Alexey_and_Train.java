import java.util.*;
import java.io.*;
// pretests passed
// error in double calculation. instead use (b-a+1)/2 for ceil. If b-a is even, still ceil. 
//and if b-a is odd then it increases to next even and (b-a+1)/2 gives int.
public class _1501_A_Alexey_and_Train//for codeForces
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
            int a[]=new int[n+1];
            int b[]=new int[n+1];
            int tm[]=new int[n+1];
            long time=0;
            for(i=1;i<=n;i++){
                a[i]=sc.nextInt();
                b[i]=sc.nextInt();
            }
            for(i=1;i<=n;i++){
                tm[i]=sc.nextInt();
            }
            long arrival=a[0], departure=0;
            for(i=1;i<=n;i++){
                //arrives after previous departure + tm[i]
                arrival=departure + tm[i] + (a[i]-b[i-1]);
                if(b[i]-arrival<(b[i]-a[i]+1)/2 )
                    departure=arrival+(int)(b[i]-a[i]+1)/2;
                else
                    departure=b[i];
            }
            //System.out.println("\n"+time);
            System.out.println("\n"+arrival);
        }
		
	}
}
