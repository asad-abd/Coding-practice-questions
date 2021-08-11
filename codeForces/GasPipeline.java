import java.util.*;
import java.io.*;
//wa
public class GasPipeline//for codeForces E71C
{
	static void pnl(Object o){
		System.out.println(o);
	} 
	static void pn(Object o){
		System.out.print(o+" ");
	}
	static long IINF=(long)1e17;
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
		//Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int p=0;p<t;p++){
			int n=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			String s=sc.next();
			long dp[][]=new long[n+1][2];
			dp[0][0]=b;
			dp[0][1]=IINF;
			int i;
			for(i = 1; i< n; i++){
            if(s.charAt(i-1) == '1'){
                dp[i][0] = IINF;
                dp[i][1] =dp[i-1][1]+2*b+a;
                //pnl("1) "+dp[i][0]+"--"+dp[i][1]);
            }else{
                dp[i][0] = Math.min(dp[i-1][0]+a+b, dp[i-1][1]+2*a+b);
                dp[i][1] = Math.min(dp[i-1][0]+2*(a+b), dp[i-1][1]+2*b+a);
                if(s.charAt(i) == '1')
                	dp[i][0] = IINF;
                //pnl("0) "+dp[i][0]+"--"+dp[i][1]);
            }
            dp[n][0] = Math.min(dp[n-1][0]+a+b, dp[n-1][1]+2*a+b);
			/*for(i = 1; i<= n; i++){
            if(s.charAt(i-1) == '1'){
                dp[i][0] = IINF;
                dp[i][1] = Math.min(dp[i-1][0]+2*a+2*b, dp[i-1][1]+2*b+a);
            }else{
                dp[i][0] = Math.min(dp[i-1][0]+a+b, dp[i-1][1]+2*a+2*b);
                dp[i][1] = Math.min(dp[i-1][0]+2*(a+b), dp[i-1][1]+2*b+a);
            }*/
        }
			/*for(i=1;i<=n;i++){
				if(s.charAt(i-1)=='0'){
					dp[i][0]=Math.min(dp[i-1][0]+a+b,dp[i-1][1]+2*a+2*b);
					dp[i][1]=Math.min(dp[i-1][0]+(a+b)*2,dp[i-1][1]+a+2*b);
				}
				else{
					dp[i-1][0]=IINF;
					dp[i][0]=Math.min(dp[i-1][0]+a+b,dp[i-1][1]+2*a+b);
					dp[i][1]=Math.min(dp[i-1][0]+(a+b)*2,dp[i-1][1]+a+2*b);
				}
			}*/
			System.out.println(dp[n][0]);
		}
		
	}
	/*public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		for(int p=0;p<t;p++){
			int n=sc.nextInt();
			int a=sc.nextInt();
			int b=sc.nextInt();
			String s=sc.next();
			long cost=0;
			int i,lastpoleLength=1;
			if(s.charAt(1)=='1'){
				lastpoleLength=2;
				//is 2a+b lesser or 2b+a
				cost+=2*a+b;
				cost+=lastpoleLength*b;
			}
			else{
				cost+=2*b+a;	
				lastpoleLength=1;
			}
			//costTilli[i] stores length of things over index i of string excluding the previous pole
			for(i=1;i<n-1;i++){
				if(s.charAt(i)=='0'&&lastpoleLength==2){
					if(s.charAt(i+1)=='0'){
						lastpoleLength=2*b+a<2*a+b?2:1;
						cost+=2*b+a<2*a+b?2*b+a:2*a+b;
						if(2*b+a==2*a+b)
							lastpoleLength=2;
					}
					else{//next char is 1
						lastpoleLength=2;
				//		cost+=2*b+a;
					}
				}
				else if(s.charAt(i)=='0'&&lastpoleLength==1){
					if(s.charAt(i+1)=='0'){
						lastpoleLength=1;
						cost+=a+b;
					}
					else{//next char is 1
						lastpoleLength=2;
						cost+=2*a+2*b;//sm done here
					}
				}
				else if(s.charAt(i)=='1'){
					lastpoleLength=2;
					cost+=2*b+a;
					
				}
			}
			if(lastpoleLength==2){
				cost+=2*a+b;
			}
			else if(lastpoleLength==1){
				cost+=a+b;
			}
			System.out.println(cost);
		}
	}*/
}