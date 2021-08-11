import java.util.*;
import java.io.*;
//
public class creatingaCharacter//for codeForces E72 A
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
		int t=sc.nextInt();
		long ans[]=new long[t];
		for(int p=0;p<t;p++){
			int str=sc.nextInt();
			int iq=sc.nextInt();
			int exp=sc.nextInt();
			int s=(exp+iq-str+1);
				if(s%2==0){
					s=Math.max((s/2),0) ;
					ans[p]=Math.max(exp-s+1,0);
				}
				else{
					s=Math.max(((s+1)/2),0) ;//not s/2 +1!!
					ans[p]=Math.max(exp-s+1,0);
				}
				
			//pnl("s "+s);

		}
		for(int i=0;i<t;i++)
		System.out.println(ans[i]);
	}
}