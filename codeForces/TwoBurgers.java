import java.util.*;
import java.io.*;
public class TwoBurgers//for codeForces E71A
{

	public static void main(String args[])
	{
		
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		int numOfBugsmade=0,profit=0,numOfBugs=0;
		for(int i=0;i<t;i++){
			profit=0;
			int b=sc.nextInt();
			int p=sc.nextInt();
			int f=sc.nextInt();
			int h=sc.nextInt();
			int c=sc.nextInt();
			numOfBugs=b/2;
			if(h>c){
				numOfBugsmade=(numOfBugs>p?p:numOfBugs);
				numOfBugs-=numOfBugsmade;
				profit+=(numOfBugsmade*h);
				if(numOfBugs>0){
					numOfBugsmade=(numOfBugs>f?f:numOfBugs);
					numOfBugs-=numOfBugsmade;
					profit+=(numOfBugsmade*c);
					
				}
			}
			else{
				numOfBugsmade=(numOfBugs>f?f:numOfBugs);
				numOfBugs-=numOfBugsmade;
				profit+=numOfBugsmade*c;
				if(numOfBugs>0){
					numOfBugsmade=(numOfBugs>p?p:numOfBugs);
					numOfBugs-=numOfBugsmade;
					profit+=numOfBugsmade*h;
					
				}
			}
			System.out.println(profit);
		}
		
	}
}