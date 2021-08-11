import java.util.*;
import java.io.*;
//TLE: but correct logic
class HS08PAUL_seive {
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
    public static void main(String args[]) throws IOException
    {
        long startTime = System.nanoTime();
        int T;
        FastReader sc=new FastReader();
        T=sc.nextInt();
        int n=10000000;
        boolean not_prime[]=new boolean[n+1];
        //primes are false
        not_prime[0]=not_prime[1]=true;
        for(int i=2;i*i<=n;i++){
            if(!not_prime[i]){
                for(int j=i*i;j<=n;j+=i){
                    not_prime[j]=true;
                }
            }
        }
        
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
        not_prime[0]=false;//for this question
        for(int tt=0;tt<T;tt++){
            int count=0;
            n=sc.nextInt();
            boolean form[]=new boolean[n+1];
            int j=0;
            for(int i=0;i*i<=n;i++){
                for(j=0; j*j*j*j<=n;j++){                    
                    if(i*i+j*j*j*j<=n && !form[i*i+j*j*j*j]) 
                        form[i*i+j*j*j*j]=true;
                }
            }
            for(int i=0;i<=n;i++){
                if(!not_prime[i] && form[i])
                    count++;
            }
            //System.out.println(count-1);
            output.write(String.valueOf(count-1)+"\n");
        }
        output.flush();
        long endTime = System.nanoTime();
 
        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;
        //System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
    
    }
}
