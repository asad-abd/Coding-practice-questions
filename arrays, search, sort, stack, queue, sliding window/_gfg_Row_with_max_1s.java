public class _gfg_Row_with_max_1s {
    int rowWithMax1s(int arr[][], int n, int m) {
        //interview approach 1: brute -> O(n*m)
        
        //interview approach 2: sorted => binary search -> O(n*log(m)): search leftmost 1 on each row
        
        //interview approach 3: start from the rhs of the topmost row and move left till 0 is encountered
        //then keep moving down till 1 is at that index, check if you can move to the LEFT.
        //that's it!
        
        int col=m-1, row=0, ansIndex=0;
        boolean seen1=false;
        while(row<n && col>=0){
            if(arr[row][col]==1){
                if(!seen1){
                    seen1=true;
                    ansIndex=row;
                }
                if(col>0 && arr[row][col-1]==1){//move left
                    col--;
                    ansIndex=row;
                }
                else//move down
                    row++;
            }
            else
                row++;
        }
        if(!seen1) return -1;
        return ansIndex;
    }
}
