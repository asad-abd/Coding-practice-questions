import java.util.*;
import java.io.*;
//
public class _1493_C_K_beautiful_Strings//for codeForces
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
	public static boolean isBeautiful(int []freq, int k){
		for(int i=0;i<freq.length;i++){
			if(freq[i]!=0 && freq[i]%k!=0)
				return false;
		}
		return true;
	}
	//logic: to check if Beautiful sub exists.
	//i: 0->n-2
	//for prefix length i, check if the sum of the min required letters to make beautiful is 
	//
	//
	//
	//
	public static void main(String args[])
	{
		System.out.println();
		int T;
		FastReader sc=new FastReader();
        T=sc.nextInt();
		int freq[] =new int[26];
		for(int tt=0;tt<T;tt++){
			int n=sc.nextInt();
			int k=sc.nextInt();
			String str=sc.next();
			if(n%k!=0)
				System.out.println(-1);
			else{
				char[] s= str.toCharArray();
				for(int i=0;i<n;i++){
					s[i-'a']++;
				}
			}
        }
		System.out.println();
	}
}
