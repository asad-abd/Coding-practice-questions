//Got only 20/100 pts because the code takes too much time for 10^5,6 numbers
/*You have become good friends with Chef. Right now, Chef is busy in the kitchen, so he asked you to solve a problem for him.

Consider a list of integers L. Initially, L contains the integers 1 through N, each of them exactly once (but it may contain multiple copies of some integers later). The order of elements in L is not important. You should perform the following operation N−1 times:

Choose two elements of the list, let's denote them by X and Y. These two elements may be equal.
Erase the chosen elements from L.
Append the number X+Y+X⋅Y to L.
At the end, L contains exactly one integer. Find the maximum possible value of this integer. Since the answer may be large, compute it modulo 1,000,000,007 (109+7).*/
import java.util.*;
import java.math.*;
import java.math.BigInteger;
import java.io.*;
class mayChallenge1//for CodeChef
{

	public static void main(String args[])
	{
		int n,t ;
		BigInteger  x,y,z,temp1;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		BigInteger  ans[]=new BigInteger [t];
		for(int i=0;i<t;i++)//inside testcase i
		{
			n=sc.nextInt();
			LinkedList <BigInteger> l = new LinkedList<BigInteger>();
			//filling the list
			for(int j=n;j>0;j--)
				l.add(BigInteger.valueOf(j));
			//deleting the first 2 elements of l till only one element left
			for(int j=1;j<=(n-1);j++)
			{
				x=l.removeFirst();
				y=l.removeLast();
				temp1=x.add(y);
				BigInteger temp2=x.multiply(y);
				l.addFirst(temp1.add(temp2));
				//System.out.println(l);
			}	
			
			//now, only 1 element left in the list, remove it also
			z=l.remove();
			ans[i]=z.mod(BigInteger.valueOf(1000000007));


		}

		for(int i=0;i<t;i++)
		{
			System.out.println(ans[i]);
		}
	}
}