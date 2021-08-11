import java.util.*;
public class _455_A_Boredom {
    
    public static int dynamicUtil(int arr[], int n, int t[], int freq[]){
        if(n<=0)
            return 0;
        if(n==1)    return freq[arr[n-1]]*arr[n-1];
        int op1=0,op2=0;
        if(t[n]!=-1) return t[n];
            
        op1= arr[n-1]*freq[arr[n-1]] + dynamicUtil(arr, n-2, t,freq);
        op2= dynamicUtil(arr, n-1, t, freq);
        return t[n]=Math.max(op1,op2);
    }
    public static int dynamic(int arr[]){
        //traverse the array and store the frequencies of the numbers
        //we want to write the unique numbers in an ascending order then
        //do in a knapsack fashion, pick n or don't pick it
        int freq[]=new int[(int)Math.pow(10,5)+2];
        int countUnique=0;
        for(int i=0;i<arr.length;i++){
            if(freq[arr[i]]==0)
                countUnique++;
            freq[arr[i]]++;
        }
        Arrays.sort(arr);
        int _arr[] =new int [countUnique];
        for(int i=0,j=0;i<arr.length;){
            _arr[j]=arr[i];
            i+=freq[_arr[j]];
            j++;
        }
        //System.out.println(Arrays.toString(_arr)+"\n");
        //for(int i=0;i<_arr.length;i++)
            //System.out.print(freq[_arr[i]]+ ", ");
        //System.out.println(Arrays.toString(freq));
        int t[]=new int[_arr.length+1];
        t[0]=0; t[1]=freq[_arr[1]];
        for(int i=2;i<=_arr.length;i++)
            t[i]=Math.max(t[i-1], t[i-2]+ _arr[i-1]*freq[_arr[i-1]]);
        return t[_arr.length];
        //return dynamicUtil(_arr, _arr.length, t, freq);
    }
    public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
            a[i]=sc.nextInt();
        System.out.println(dynamic(a));
        //System.out.println(knapsack(a, n, new boolean[n*2], t));
	}
}
