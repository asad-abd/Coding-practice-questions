class Solution{
//https://practice.geeksforgeeks.org/problems/even-and-odd/1/?company[]=Paytm&company[]=Paytm&page=1&sortBy=newest&query=company[]Paytmpage1sortBynewestcompany[]Paytm#
	static void reArrange(int[] arr, int n) {
        int lastOdd = 1, lastEven = 0;
        while(lastOdd < n && lastEven < n){
            //find the left most even index that has a mismatch
            while(lastOdd < n && arr[lastOdd] % 2 != 0)
                lastOdd += 2;
            //find the left most odd index that has a mismatch
            while(lastEven < n && arr[lastEven] % 2 == 0)
                lastEven += 2;
            //if this stopped before n then it means we have a mismatch
            if(lastEven < n && lastOdd < n){
                int temp = arr[lastEven];
                arr[lastEven] = arr[lastOdd];
                arr[lastOdd] = temp;
                //lastEven += 2;
                //lastEven += 2;
            }
        }
    }
}
