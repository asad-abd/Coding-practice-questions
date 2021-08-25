import java.util.*;
//watch aditya verma video for doubt
//simply return Max((nsr-nsl-1)*heights[i])
class _84_largest_rectangle_in_histogram {
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
    public int largestRectangleArea(int[] heights) {
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
}
