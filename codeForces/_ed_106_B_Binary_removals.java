import java.io.*;
import java.util.*;

public class _ed_106_B_Binary_removals {
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
            String s=sc.next();
            char a[]=s.toCharArray();
            //find the first 11 pair, that'll be the separator. useless characters before them (1*1) can be removed. 
            //if no such pair found, return true.
            //if found, traverse RHS, if any adjacent 00 found, return false, else true
            boolean ans=true;

            for(int i=0;i<a.length-1;i++){
                if(a[i]=='1' && a[i+1]=='1'){
                    for(int j=i+2;j<a.length-1;j++){
                        if(a[j]=='0' && a[j+1]=='0'){
                            ans=false;
                            break;
                        }
                    }
                    if(!ans)
                        break;
                }
                if(!ans) break;
            }
            if(ans)
                System.out.println("YES");
            else    
                System.out.println("NO");

        }
    }
}
