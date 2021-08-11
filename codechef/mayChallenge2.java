/*Ari and Rich are playing a pretty confusing game. Here are the rules of the game:

The game is played with two piles of matches. Initially, the first pile contains N matches and the second one contains M matches.
The players alternate turns; Ari plays first.
On each turn, the current player must choose one pile and remove a positive number of matches (not exceeding the current number of matches on that pile) from it.
It is only allowed to remove X matches from a pile if the number of matches in the other pile divides X.
The player that takes the last match from any pile wins.
It can be proved that as long as both piles are non-empty, there is always at least one valid move, so the game must end by emptying some pile. Both Ari and Rich play optimally. Determine the winner of the game.*/
import java.util.*;
import java.io.*;
class mayChallenge2//for CodeChef
{

	public static void main(String args[])
	{
		int t ;
		long n,m;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int i=0;i<t;i++)
		{
			n=sc.nextLong();
			m=sc.nextLong();
			int count=0;
			while(true)
			{
				if(n>=m)
				{
					long temp=(n/m);
					n=n-temp*m;
					System.out.println(temp);
				}
				else
				{
					long temp=m/n;
					m=m-temp*n;
				}
				count=(count==0)?1:0;
				if(n==0 || m==0)
					break;
			}
			ans[i]=count;
		}

		for(int i=0;i<t;i++)
		{
			if(ans[i]==1)
				System.out.println("Ari");
			else
				System.out.println("Rich");
		}
	}
}