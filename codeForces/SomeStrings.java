
import java.util.*;
import java.io.*;
public class SomeStrings//for CodeForces E70-E
{
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
	public static void main(String args[])throws IOException{
		FastReader sc=new FastReader();
		String t=sc.next();
		int n=sc.nextInt();
		String s[]=new String[n];
		int ans=0;
		int clBraces[]=new int[t.length()];
		int opBraces[]=new int[t.length()];		
		for(int i=0;i<n;i++){
			s[i]=sc.next();
		}
		for(int j=0;j<n;j++){
			int lps[]=new int[s[j].length()];
			makeLps(s[j],lps);
			KMPSearch(t,s[j],lps,opBraces,clBraces);
		}
		for(int i=0;i<opBraces.length-1;i++){
			ans+=(clBraces[i]*opBraces[i+1]);
		}
		//for(int i=0;i<lps.length;i++){
		//	System.out.print(lps[i]+" ");
		//}
		System.out.println(ans);
	}
}