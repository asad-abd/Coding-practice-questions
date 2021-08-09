class VMware_round1_Min{
    public static int Minima(int arr[], int n){
	    if(n==0)
  	        return arr[n];
        return Math.min(Minima(arr,n-1), arr[n]);
    }
    public static void main(String args[]){
        int arr[]= {2, 3, 6, 1, 98};
        System.out.println(Minima(arr, arr.length-1)); 
    }
}
