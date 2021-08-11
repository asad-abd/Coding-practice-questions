import java.util.*;
import java.io.*;
class TRIP2//for CodeChef
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
	public static void main(String args[])throws IOException{
		FastReader sc=new FastReader();
		int t;
		t=sc.nextInt();
		String ans[]=new String[t];
		for(int p=0;p<t;p++){
			boolean flag=true;
			int n=sc.nextInt();
			int k=sc.nextInt();
			int a[]=new int[n];
			for(int i=0;i<n;i++)
				a[i]=sc.nextInt();
			if(k==2){
				if(a[0]==-1){
					//2 starts possible;
					a[0]=1;
					for(int i=1;i<n;i++){
						if(a[i]==-1)
							a[i]=2-a[i-1]+1;
					}
					for(int i=1;i<n;i++){
						if(a[i]==a[i-1]){
							flag=false;
							break;
						}
					}
					if(flag==false){
						a[0]=2;
						for(int i=1;i<n;i++){
							if(a[i]==-1)
								a[i]=2-a[i-1]+1;
						}
						for(int i=1;i<n;i++){
							if(a[i]==a[i-1]){
								flag=false;
								break;
							}
						}
					}
				}
				else/*first char is not -1*/{
					for(int i=1;i<n;i++){
						if(a[i]==-1)
							a[i]=2-a[i-1]+1;
					}
					for(int i=1;i<n;i++){
						if(a[i]==a[i-1]){
							flag=false;
							break;
						}
					}
					
				}

			}
			else//k!=2
			{

				for(int i=0;i<n;i++){
					if(i==0){
						if(a[0]==-1)
							for(int j=1;j<=3;j++){
								if(n>1&&j!=a[1])
									a[0]=j;
								else
									a[0]=k;
							}
					}
					else if(i>0&&i<n-1){
						if(a[i]==-1)
							for(int j=1;j<=3;j++)
								if(j!=a[i-1]&&j!=a[j+1])
									a[i]=j;
					}
					else{
						if(a[i]==-1)
							for(int j=1;j<=3;j++)
								if(j!=a[i-1])
									a[i]=j;
					}
				}
				for(int i=1;i<n;i++){
					if(a[i]==a[i-1]){
						flag=false;
						break;
					}
				}

			}
			if(flag==true){
				System.out.println("YES");
				for(int i=0;i<n;i++)
					System.out.print(a[i]+" ");
				System.out.println();
			}
			else
				System.out.println("NO");
		} 

	}
}