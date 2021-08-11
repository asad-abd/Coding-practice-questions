import java.util.*;
public class _240_A_Mashmokh_and_numbers {
    //https://codeforces.com/problemset/problem/414/A
    //DONE!
    public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int k=sc.nextInt();
        int pairs=n/2;
        if(n==1){
            if(k==0)
                System.out.println(1);
            else
                System.out.println(-1);
            System.exit(0);
        }
        if(k<pairs){
            System.out.println(-1);
            System.exit(0);
        }    
        
        HashSet<Integer> hset =new HashSet<>();
        int t=k-pairs+1;
        System.out.print(t+" "+(2*t)+" ");
        hset.add(t);
        hset.add(t*2);
        int j=1;
        if(hset.contains(j) || hset.contains(1+j))
            j=j+2;
        for(int i=1;i<pairs;i++){
            while(hset.contains(j) || hset.contains(j+1))
                j++;
            System.out.print(j+" "+(1+j)+" ");
            hset.add(j);
            hset.add(j+1);
        }
        if(pairs*2!=n){
            while(hset.contains(j))
                j++;
            System.out.print(j);
        }
	}
}
