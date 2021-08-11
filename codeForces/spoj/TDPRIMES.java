import java.util.*;
import java.io.*;
class TDPRIMES {
    //TLE, though, shouldn't get it
    public static void main(String args[]) throws IOException
    {
        long startTime = System.nanoTime();
 
        Scanner sc=new Scanner(System.in);
        int n=(int)Math.pow(10,8);
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
        int count=0;
        BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
  
        for(int i=2;i<=n;i++){
            if(!not_prime[i]) count++;
            if(!not_prime[i] && (count-1)%100==0)
                output.write(String.valueOf(i)+"\n");
        }
        output.flush();

        long endTime = System.nanoTime();
 
        // get difference of two nanoTime values
        long timeElapsed = endTime - startTime;
 
        System.out.println("Execution time in milliseconds : " + timeElapsed / 1000000);
    
    }
}
