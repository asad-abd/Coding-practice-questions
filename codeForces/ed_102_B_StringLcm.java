import java.util.*;
import java.io.*;
public class ed_102_B_StringLcm {
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
		FastReader sc=new FastReader();
        int T=sc.nextInt();
        for(int t=0;t<T;t++){
            //p<q
            String p=sc.next();
            String q=sc.next();
            if(p.length()>q.length()){
                String temp=p;
                p=q;
                q=temp;
            }
            //String s=""+p+q;
            int i=0,j=0;
            int val=0;
            boolean flag=true;
            for(j=0;j<q.length();j++){
                if(p.charAt(i)!=q.charAt(j)){
                    System.out.println("-1");
                    flag=false;
                    break;
                }
                val++;
                i=(i+1)%(p.length());
            }
            if(flag){
                if(p.charAt(p.length()-1)==q.charAt(q.length()-1)){
                    if(q.length()%p.length()==0){
                        System.out.println(q);
                    }
                    else{
                        String s="";
                        for(int k=0;k<p.length();k++){
                            s+=q;
                        }
                        System.out.println(s);
                    }
                }
                else
                    System.out.println("-1");

            }
        }
		//System.out.println(ans);
	}
}
