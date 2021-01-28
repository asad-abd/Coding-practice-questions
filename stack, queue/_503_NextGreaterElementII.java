//Stack qustion!
//just be certaion of whether you're pushing the index onto the stack or the number itself
import java.util.*;
class _503_NextGreaterElementII {
    public int[] nextGreaterElements(int[] nums) {
        
        if(nums.length==0)
            return new int[0];
        Stack<Integer> stack =new Stack<>();
        int maxIndex=0,n=nums.length;
        int ans[]=new int[n];
        for(int i=0;i<n;i++){
            if(nums[maxIndex]<nums[i])
                maxIndex=i;
        }
        //System.out.println("maxINdex: "+maxIndex);
        ans[maxIndex]=-1;
        int i=maxIndex==0?n-1:maxIndex-1;
        stack.push(maxIndex);
        for(int count=0;count<n-1;count++){
            while(stack.size()>0 && nums[stack.peek()]<=nums[i]){
                stack.pop();
            //System.out.println(nums[stack.peek()]+" -"+ i+  "- "+nums[i]);
                //System.out.println(nums[i]+" "+stack);
                }
            if(stack.size()==0)
                ans[i]=-1;
            else
                ans[i]=nums[stack.peek()];
            //System.out.println(nums[i]+" "+stack);
            stack.push(i);
            
            i=i==0?n-1:i-1;
        }
        return ans;
    }
}