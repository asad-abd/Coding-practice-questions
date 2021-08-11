import java.util.*;
import java.io.*;
//
public class fadiLCM//for codeForces
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
	public static long gcd(long a, long b) 
    { 
      if (b == 0) 
        return a; 
      return gcd(b, a % b);  
    } 
	public static void main(String args[])
	{
		long x;
        FastReader sc=new FastReader();
        x=sc.nextLong();
        if(x==1)
            System.out.println(1+" "+1);
       else
		for(int i=(int)Math.sqrt(x);i>0;i--){
			long a=x/i,b=i;
			if(x%i==0 && gcd(a,b)==1){
                System.out.println(i+" "+x/i);
                break;
            }
        }
		
	}
}
