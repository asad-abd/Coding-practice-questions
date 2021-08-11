import java.util.*;
import java.io.*;
class Encoding//for CodeChef august 2019
{
	static String findSum(String str1, String str2)  
	{  
	    // Before proceeding further, make sure length  
	    // of str2 is larger.  
	    if (str1.length() > str2.length()){  
	        String t = str1; 
	        str1 = str2; 
	        str2 = t; 
	    } 
	  
	    // Take an empty String for storing result  
	    String str = "";  
	  
	    // Calculate length of both String  
	    int n1 = str1.length(), n2 = str2.length();  
	  
	    // Reverse both of Strings 
	    str1=new StringBuilder(str1).reverse().toString(); 
	    str2=new StringBuilder(str2).reverse().toString(); 
	  
	    int carry = 0;  
	    for (int i = 0; i < n1; i++)  
	    {  
	        // Do school mathematics, compute sum of  
	        // current digits and carry  
	        int sum = ((int)(str1.charAt(i) - '0') +  
	                    (int)(str2.charAt(i) - '0') + carry);  
	        str += (char)(sum % 10 + '0');  
	  
	        // Calculate carry for next step  
	        carry = sum / 10;  
	    }  
	  
	    // Add remaining digits of larger number  
	    for (int i = n1; i < n2; i++)  
	    {  
	        int sum = ((int)(str2.charAt(i) - '0') + carry);  
	        str += (char)(sum % 10 + '0');  
	        carry = sum / 10;  
	    }  
	  
	    // Add remaining carry  
	    if (carry > 0)  
	        str += (char)(carry + '0');  
	  
	    // reverse resultant String 
	    str = new StringBuilder(str).reverse().toString(); 
	  
	    return str;  
	} 
//
	static long findDiff(String r, String l) //r>=l
	{ 
	    String str1 = r; 
	    String str2 = l; 
	    // Take an empty string for storing result 
	    String str = ""; 
	  
	    // Calculate length of both string 
	    int n1 = str1.length(), n2 = str2.length(); 
	  
	    // Reverse both of strings 
	    str1 = new StringBuilder(str1).reverse().toString(); 
	    str2 = new StringBuilder(str2).reverse().toString(); 
	      
	    int carry = 0; 
	  
	    // Run loop till small string length 
	    // and subtract digit of str1 to str2 
	    for (int i = 0; i < n2; i++) 
	    { 
	        // Do school mathematics, compute difference of 
	        // current digits 
	        int sub = ((int)(str1.charAt(i)-'0') - (int)(str2.charAt(i)-'0')-carry); 
	          
	        // If subtraction is less then zero 
	        // we add then we add 10 into sub and 
	        // take carry as 1 for calculating next step 
	        if (sub < 0) 
	        { 
	            sub = sub + 10; 
	            carry = 1; 
	        } 
	        else
	            carry = 0; 
	  
	        str += (char)(sub + '0'); 
	    } 
	  
	    // subtract remaining digits of larger number 
	    for (int i = n2; i < n1; i++) 
	    { 
	        int sub = ((int)(str1.charAt(i) - '0') - carry); 
	          
	        // if the sub value is -ve, then make it positive 
	        if (sub < 0) 
	        { 
	            sub = sub + 10; 
	            carry = 1; 
	        } 
	        else
	            carry = 0; 
	              
	        str += (char)(sub + '0'); 
	    }

   		// reverse resultant string 
   		str1= new StringBuilder(str).reverse().toString(); 
   		return Long.parseLong(str1);
	} 
//
	public static void main(String args[])
	{
		int t;
		int nl,nr;
		String l,r;
		Scanner sc=new Scanner(System.in);
		t=sc.nextInt();
		int ans[]=new int[t];
		for(int p=0;p<t;p++)
		{
			nl=sc.nextInt();l=sc.next();
			nr=sc.nextInt();r=sc.next();
			String fx="",curr=l;
			for(long i=0;i<=findDiff(r,l);i++)
			{
				for(int j=0;j<curr.length();j++)


				curr=findSum(curr,"1");//curr++
			}
		}

		for(int p=0;p<t;p++)
		{
			System.out.println(ans[p]);
		}
	}
}