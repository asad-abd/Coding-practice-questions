import java.util.*;
import java.io.*;
//
public class WASD//for codeForces E 70-c
{

	public static void main(String args[]){
		int t;
		String s;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++){
			s=sc.next();
			int minx=0,maxx=0,miny=0,maxy=0,x=0,y=0,cminx=0,cmaxx=0,cminy=0,cmaxy=0;
			int co[][]=new int[s.length()+1][2];
			int i;
			for(i=0;i<s.length();i++){
				co[i][0]=x;
				co[i][1]=y;
				if(s.charAt(i)=='W')
					y++;
				else if(s.charAt(i)=='S')
					y--;
				else if(s.charAt(i)=='D')
					x++;
				else
					x--;
				maxx=x>maxx?x:maxx;
				maxy=y>maxy?y:maxy;
				minx=x<minx?x:minx;
				miny=y<miny?y:miny;
			}
			co[i][0]=x;
			co[i][1]=y;
			for(i=0;i<s.length()+1;i++){
				int temp=0;
				if(co[i][0]==maxx){
					cmaxx+=1;
				}
				if(co[i][1]==maxy){
					cmaxy+=1;
				}
				if(co[i][0]==minx){
					cminx+=1;
				}
				if(co[i][1]==miny){
					cminy+=1;
				}
			}
			System.out.println("\n"+cmaxx+"\t"+cminx+"\t"+cmaxy+"\t"+cminy+"\t");
			//IF 2 POINTS GET THE SAME max or min we cannot sub/add 1 to it
			x=maxx-minx+1;
			y=maxy-miny+1;
			int area1=x*y,area2=x*y;
			if(cminy==1 || cmaxy==1){
				if(y>1)
					area1=x*(y-1);
			}
			if(cminx==1 || cmaxx==1){
				if(x>1)
					area2=(x-1)*y;
			}
			ans[p]=area1<area2?area1:area2;
			}
		for(int i=0;i<t;i++)
		System.out.println(ans[i]);
	}
}