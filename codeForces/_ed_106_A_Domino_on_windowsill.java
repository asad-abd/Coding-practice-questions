import java.io.*;
import java.util.*;

public class _ed_106_A_Domino_on_windowsill {
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
        String []ans=new String[T];
        for(int tt=0;tt<T;tt++){
            int n=sc.nextInt();
            int k1=sc.nextInt();
            int k2=sc.nextInt();
            int w=sc.nextInt();
            int b=sc.nextInt();
            if((k1+k2)/2 < w || (2*n-k1-k2)/2 < b)
                ans[tt]="NO";
                
            else
                ans[tt]="YES";
            
        }
        for(int i=0;i<T;i++){
            System.out.println(ans[i]);
        }
    }
}
