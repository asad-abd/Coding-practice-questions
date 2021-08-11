import java.util.*;

public class _ed_104_B_Cat_cycle {
    public static void main(String args[])
	{
		int T;
		Scanner sc=new Scanner(System.in);
		T=sc.nextInt();
        for(int t=0;t<T;t++){
            int n=sc.nextInt();
            int k=sc.nextInt();
            if(n%2==0)
                System.out.println( ((k+1)%n +1 ));
            else{
                int collisions=
                    System.out.println(((k+2*div -1)%n +1) );
            }
        }
		
	}
}