import java.util.*;
public class _274_A_k_multiple_free_set {//accepted
//SMC : nice question
// https://codeforces.com/problemset/problem/274/A
// CATCH: approach to remove numbers whose x*2 is available in array is WRONG
//by above logic: 1 2 3 4 5 6 7 8 9 10 => {6,7,8,9,10} but we can have the set {1,3,7,8,9,10} size 6!!
//correct logic: in any chain, x, x*k, x*k*k, x*k*k*k... we can't pick any consecutive numbers from this set.
// so check if a number a[i] is divisible by k and if yes, then check if it contains x/k or x*k, mark which you've chosen to be in the set

    public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int k=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        Arrays.sort(a);
        int count=0;
        HashSet<Integer> taken=new HashSet<>();
        for(int i=0;i<n;i++){
            //since array is sorted, we mark the current a[i] taken if the previous in chain was not taken
            if(a[i]%k ==0 ){
                //boolean found=search(a,i,n-1,a[i]/k);
                if(!taken.contains(a[i]/k)){
                    //prev in chain was not taken
                    taken.add(a[i]);
                    count++;
                }
            //else{                    /*prev in chain was taken, can't take this.*/    }
            }
            else{
                taken.add(a[i]);
                count++;
            }
        }
        System.out.println(count);
	}
}
