//MY FIRST SEGMENT TREE QUESTION
import java.util.*;
import java.io.*;
//AC using fastreader!! scanner TLE
public class _339_Xenia_and_Bit_operations {
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
    /////////////////////// CODE ///////////////////////////////////
   static long a[];
   static long seg[];
   
   public static void build(int ind, int low, int high, boolean or){
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
        build(2*ind+1, low, mid, !or);
        build(2*ind+2, mid+1, high, !or);
        if(or==true)
            seg[ind]=seg[2*ind+1] | seg[2*ind+2];
        else
            seg[ind]=seg[2*ind+1] ^ seg[2*ind+2];
        return;
   } 
   public static void pointUpdate(int ind, int low, int high, int node, long val, boolean or){
        if(low>high) return;
        if(low==high){ 
            seg[ind]=val;//not seg[low]!!!!! (constant error due to this!)
            //System.out.println(Arrays.toString(seg));
        }
        else{
            int mid=low+(high-low)/2;
            if(node>=low && node<=mid) pointUpdate(2*ind+1,SEGMENT low, mid, node, val, !or);
            else pointUpdate(2*ind+2, mid+1, high, node, val, !or);
            if(or==true)
                seg[ind]=seg[2*ind+1] | seg[2*ind+2];
            else
                seg[ind]=seg[2*ind+1] ^ seg[2*ind+2];
            return;
        }
   }
   public static void main(String args[])
	{
		FastReader sc=new FastReader();
		int n=sc.nextInt();
        int m=sc.nextInt();
        int cap=1<<n;
        a=new long[cap];
        seg=new long[2*cap+2];
        //System.out.println("high: "+(cap-1));
        for(int t=0; t<cap; t++)
            a[t]=sc.nextLong();
        //System.out.println(Arrays.toString(a));
        boolean or;
        if(n%2==0) or=false;
        else or=true;

        build(0,0,cap-1,or);
        
        if(n%2==0) or=false;
        else or=true;
        //System.out.println(Arrays.toString(seg));
		for(int i=0;i<m;i++){
            int index=sc.nextInt();
            long val=sc.nextLong();
            pointUpdate(0, 0, cap-1, index-1, val, or);
            System.out.println(seg[0]);
        }
	}
}
