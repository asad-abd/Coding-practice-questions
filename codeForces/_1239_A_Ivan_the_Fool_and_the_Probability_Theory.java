import java.util.*;
//
public class _1239_A_Ivan_the_Fool_and_the_Probability_Theory {
    int IINF=Integer.MAX_VALUE;
	static long mod=1000000007;
    public static void main(String args[])
	{
		int T;
		Scanner sc=new Scanner(System.in);
		int row=sc.nextInt();
        int col=sc.nextInt();
		long a=1, b=1, c=0,d=0;
        for(int i=2; i<=row; i++){
			c=(a+b)%mod;
			a=b;
			b=c;
		}
		a=b=1;
        for(int i=2; i<=col; i++){
			d=(a+b)%mod;
			a=b;
			b=d;
		}  
		if(col==1 && row==1)
			System.out.println(2);
        else if(col==1 || row==1)
			System.out.println((2*(c+d))%mod);
        else
			System.out.println((2*(c+d-1))%mod);
		// -1 because one ordering will give a chess
		// note that we aren' considering color swap until *2 at the end

	}
}
