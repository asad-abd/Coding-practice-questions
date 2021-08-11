import java.util.*;
public class _401_A_String_Game {
    int IINF=Integer.MAX_VALUE;
	static long mod=1000000007;

	public static boolean isSubsequence(String a, String b){
        //a<=b
        int i=0,j=0;
        while(i<a.length() && j<b.length()){
            while(j<b.length() && a.charAt(i)!=b.charAt(j))
                j++;
            if(j>=b.length()) return false;
            i++;
            j++;
        }
        if(i<a.length()) return false;
        return true;
    }
	public static void main(String args[])
	{
		int T;
		Scanner sc=new Scanner(System.in);
		String og=sc.next();
        String tar=sc.next();
        int permu[] =new int[og.length()];
        for(int i=0; i<og.length(); i++)
            permu[i]=sc.nextInt();
        int st=0,end=og.length()-1, mid;
        char temp;
        StringBuilder str=new StringBuilder(og);
        int ans=0;
        while(st<=end){
            mid= st + (end-st)/2;
            //mark og[mid] as 0 (but save it aswell)
            temp=str.charAt(mid);
            str.setCharAt(mid,'0');
            if(isSubsequence(tar,str.toString())){
                ans=mid;
                st=mid+1;
            }
            else{
                //unmark mid
                str.setCharAt(mid,temp);
                end=mid-1;
            }
        }
        System.out.println(ans-1);
        
		
	}
}
