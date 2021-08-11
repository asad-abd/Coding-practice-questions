import java.util.*;
import java.io.*;
//
public class numberOfGoodSubstrings//for codeForces E72 C
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
	public static boolean equivalentNumbers(String s1,String s2){
		//first find the first occurence of 1 in s1
		int sts1=0; 
		for(int i=0;i<s1.length();i++){
			if(s1.charAt(i)=='1'){
				sts1=i;
				break;
			}
		}
		if(s1.length()-sts1!=s2.length())
			return false;
		//else
		for(int i=0;i<s2.length();i++){
			if(s1.charAt(sts1+i)!=s2.charAt(i))
				return false;
		}
		return true;
	}
	public static String toDecimal(int n){
		String s="";
		while(n>0){
			if(n%2==0)
				s="0"+s;
			else
				s="1"+s;
			n/=2;
		}
		return s;
	}
	public static void main(String args[])
	{
		FastReader sc=new FastReader();
		int t=sc.nextInt();
		long ans[]=new long[t];
		for(int p=0;p<t;p++){
			String s=sc.next();
			int n=s.length();
			for(int i=0;i<n;i++){
				for(int j=i;j<n;j++){
					String s2=toDecimal(j-i+1);
					//pnl("to decimal of "+(j-i+1)+" is "+s2);
					if(equivalentNumbers(s.substring(i,j+1),s2)){
						ans[p]++;
						//pnl(i+" "+j+" "+decimal(s.substring(i,j+1))+"  "+s.substring(i,j+1));
					}
				}
			}
		}
		for(int i=0;i<t;i++)
			System.out.println(ans[i]);
	}
}