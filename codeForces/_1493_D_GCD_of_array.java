import java.util.*;
import java.io.*;

public class _1493_D_GCD_of_array//for codeForces
{
    /* gcd of two numbers separately and then their modulo gives wrong answer! someone on CF:-
    "gcd of a set of numbers is the number consisting of the intersection of the prime numbers of each number in the set. 
    You just need to take the modulo remainder of any number from the set to ruin everything"
    
    So, simple solution is, take note of the least common prime number's power. because that's essentially what gcd is!
    */
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
    static long a[];
    static long seg[];
    static long GCD(long a, long b)
    {
        if(a<b){
            a=a+b;
            b=a-b; // b=a
            a=a-b; // a=b
        }
      if (b == 0)
        return a;
      return GCD(b, a % b); 
    }
    public static void build(int ind, int low, int high){
        if(low==high){
            seg[ind]=a[low];
            return;
        }
        /*else if(low+1==high){
            if(or==true)
                seg[ind]=a[low] | a[high];
            else
                seg[ind]=a[low] ^ a[high];
            //return;
        }*/
        if(low>high) return;

        int mid= low + (high-low)/2;
        build(2*ind+1, low, mid);
        build(2*ind+2, mid+1, high);
        seg[ind]=GCD(seg[2*ind+1], seg[2*ind+2])%mod;
        
        return;
    } 
    public static void pointUpdate(int ind, int low, int high, int node, long val){
        if(low>high) return;
        if(low==high){ 
            seg[ind]=val;//not seg[low]!!!!! (constant error due to this!)
            //System.out.println(Arrays.toString(seg));
        }
        else{
            int mid=low+(high-low)/2;
            if(node>=low && node<=mid) pointUpdate(2*ind+1,low, mid, node, val);
            else pointUpdate(2*ind+2, mid+1, high, node, val);
            seg[ind]=GCD(seg[2*ind+1], seg[2*ind+2])%mod;
            
            return;
        }
    }
	public static void main(String args[])
	{
		
		FastReader sc=new FastReader();
        int n=sc.nextInt();
		int q=sc.nextInt();
        a=new long[n];
        seg=new long[4*n];
        for(int t=0; t<n; t++)
            a[t]=sc.nextLong();
        build(0,0,n-1);
        
        for(int i=0; i<q; i++){
            int index=sc.nextInt();
            int x=sc.nextInt();
            pointUpdate(0, 0, n-1, index-1, a[index-1]*x);
            System.out.println(seg[0]%mod);
        }
		//System.out.println(ans);
	}
}
