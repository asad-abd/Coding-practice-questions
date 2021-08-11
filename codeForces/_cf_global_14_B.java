import java.util.*;
import java.io.*;
public class _cf_global_14_B{
    static long mod=1000000007;
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
            double sqrt=Math.sqrt(n);
            if(n==2){
                System.out.println("YES");
                continue;
            }
            if(sqrt*sqrt!=n){
                System.out.println("NO");
            }
            else{
                if(sqrt%2!=0 && sqrt%4!=0)
                    System.out.println("NO");
                else
                    System.out.println("YES");
            }
        }
        
    }
}
