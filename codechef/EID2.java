import java.util.*;
import java.io.*;
class EID2//for CodeChef
{
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
	//program starts here
	public static void main(String args[])
	{
		int t;
		int a[]=new int[3];
		int c[]=new int[3];
		FastReader sc=new FastReader();
		t=sc.nextInt();
		for(int p=0;p<t;p++)
		{
			boolean fair=true;
			for(int i=0;i<3;i++)
				a[i]=sc.nextInt();
			for(int i=0;i<3;i++)
				c[i]=sc.nextInt();
			for(int i=0;i<2;i++){
				for(int j=i+1;j<3;j++){
					if(a[i]>a[j]&&c[i]<=c[j]){
						fair=false;
						break;
					}
					else if(a[i]<a[j]&&c[i]>=c[j]){
						fair=false;
						break;
					}
					else if(a[i]==a[j]&&c[i]!=c[j]){
						fair=false;
						break;
					}
				}
				if(fair!=true)
					break;
			}
			if(fair==true)
				System.out.println("FAIR");
			else
				System.out.println("NOT FAIR");

			
		}

	}
}