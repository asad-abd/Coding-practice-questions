public class _84_Largest_Rectangle_in_histogram {//lc_hard
    //IMP
    //Idea: notice that the min area would be if we take just one height*1. so, keeoing that in mind,
    //we will say that, consider the i'th height in full and find which heights on the left and right can also be taken with it.
    
    public int[] inflectionPointR(int []heights, int precompute[]){//returns the largest index(I) on the RHS of 'i' s.t. heights at all indices till 'I'(including I) are >= height at i.
        Stack<Integer> stack = new Stack<>();
        //stack.push(heights.length-1);
        for(int i=heights.length-1;i>=0;i--){
            if(stack.size()>0 && heights[stack.peek()]<heights[i]){
                while(stack.size()>0)
                    stack.pop();
            }
            precompute[i]=stack.size();
            stack.push(i);
        }
        return precompute;
    }
    public int[] inflectionPointL(int []heights, int precompute[]){//returns the largest index(I) on the LHS of 'i' s.t. heights at all indices from 'I'(including I) till i-1 are >= height at i.
        
        Stack<Integer> stack = new Stack<>();
        //stack.push(heights.length-1);  
        for(int i=0;i<heights.length;i++){
            if(stack.size()>0 && heights[stack.peek()]<heights[i]){
                while(stack.size()>0)
                    stack.pop();
            }
            precompute[i]=stack.size();
            stack.push(i);
        }
        return precompute;
    }
    public int largestRectangleArea(int[] heights) {
        int ans=0, n=heights.length;
        int iP_Right[] = new int[n];
        int iP_Left[] = new int[n];
        inflectionPointR(heights, iP_Right);
        inflectionPointL(heights, iP_Left);
            
        for(int i=0;i<n;i++){
            ans=Math.max(ans, heights[i]*(iP_Right[i] + iP_Left[i] + 1) );
        }System.out.println(Arrays.toString(iP_Left));
        System.out.println(Arrays.toString(iP_Right));
        return ans;
    }
}
