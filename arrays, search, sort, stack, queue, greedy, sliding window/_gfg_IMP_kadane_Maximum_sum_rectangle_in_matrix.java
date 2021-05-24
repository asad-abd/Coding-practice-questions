class _gfg_IMP_kadane_Maximum_sum_rectangle_in_matrix {
    //my thinking: fix the columns and then squish the matrix (with the fixed columns). 
    //we see a 1D array!! representing sum of rows contained within the columns
    //since we are not concerned with finding the actual c1,c2,r1,r2 -> no need to worry about the rows' indices. Only the sum matters.
    int kadane(int []arr){
        int sum=0;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<arr.length;i++){
            //consider arr[i] in max/don't consider it
            sum+=arr[i];
            max=Math.max(sum,max);
            sum=Math.max(0,sum);
        }
        return max;
    }
    int maximumSumRectangle(int R, int C, int M[][]) {
        //fix the cols and then for c1. make a cumulative sum of rows(adding row wise)
        //select the max sum subarray using kadane's!!
        
        //calculating the prefixes for row difference
        //prefixSum[r][c] denotes the sum of row r from column 0 to c(inclusive)
        int prefixSum[][]=new int [R][C];
        for(int r=0;r<R;r++){
            for(int c=0;c<C;c++){
                if(c==0)
                    prefixSum[r][c]=M[r][c];
                else
                    prefixSum[r][c]=M[r][c]+prefixSum[r][c-1];
            }
        }
        int ans=Integer.MIN_VALUE;
        for(int c1=0;c1<C;c1++){
            for(int c2=0;c2<=c1;c2++){
                int temp[]=new int[R];
                for(int r=0;r<R;r++){
                    if(c2==0 )
                        temp[r]=prefixSum[r][c1];
                    else
                        temp[r]=prefixSum[r][c1]-prefixSum[r][c2-1];
                }
                //kadane for selecting the max sum subarray/rows
                //System.out.println(c2+" - "+c1);
                //System.out.println(Arrays.toString(temp));
                
                int max=kadane(temp);
                //System.out.println(" max "+max);
                ans=Math.max(ans,max);
            }
        }
        return ans;
    }
}