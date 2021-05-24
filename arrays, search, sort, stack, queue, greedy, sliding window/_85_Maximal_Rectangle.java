import java.util.*;
class Solution {
    //aditya verma video
    //built on _84_largest area in histogram
    public int [] nSR(int[] heights){
        int array[]=new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=heights.length-1;i>=0;i--){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]) 
                stack.pop();
            if(stack.size()==0){
                array[i]=heights.length;
                
            }
            else{
                array[i]=stack.peek();
            }
            stack.push(i);
        }
        return array;
    }
    public int [] nSL(int[] heights){
        int array[]=new int[heights.length];
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while(stack.size()>0 && heights[stack.peek()]>=heights[i]) 
                stack.pop();
            if(stack.size()==0){
                array[i]=-1;
            }
            else{
                array[i]=stack.peek();
            }
            stack.push(i);
        }
        return array;
    }
    public int largestRectangleAreaInHistogram(int[] heights) {
        int ans=0, n=heights.length;
        int nsl[] = nSL(heights);
        int nsr[] = nSR(heights);
        //System.out.println(Arrays.toString(nsr));
        //System.out.println(Arrays.toString(nsl));
        for(int i=0;i<n;i++){
            ans=Math.max(ans, heights[i]*(nsr[i]-nsl[i]-1));
        }
        
        return ans;
    }
    public int maximalRectangle(char[][] matrix) {
        int ans=0;
        ArrayList<int[]> arrays= new ArrayList<>();
        if(matrix.length==0)
            return 0;
        int arr[]=new int[matrix[0].length];
        for(int j=0;j<matrix.length;j++){
            for(int i=0;i<matrix[0].length;i++){
                if(matrix[j][i]=='0') arr[i]=0;
                else arr[i]++;
            }
            //System.out.println(Arrays.toString(arr));
            ans=Math.max(ans, largestRectangleAreaInHistogram(arr));
        }
        
        return ans;
    }
}