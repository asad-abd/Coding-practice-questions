import java.util.*;
public class _378_Kth_Smallest_Element_in_a_sorted_matrix {
    //try for binary search approach (got confused)
    //my O(klogk) approach using minHeap
    //another slight modification to remove the inPQ[][]->
    //push the starting tuples of all either all rows or all columns. now we have n heads simultaneously in the PQ
    //if row heads chosen, after pop, push the element on the right in the PQ. incase of col heads, push bottom elements.
    //this new approach is 96% fast
    public class Tuple{
        int val, x, y; 
        public Tuple(int a, int b, int value){
            val=value;
            x=a;
            y=b;
        }
    }
    public int kthSmallest(int[][] matrix, int k) {
        int n=matrix.length;
        boolean [][] inPQ = new boolean[n][n];
        PriorityQueue<Tuple> pq=new PriorityQueue<>((a,b)-> Integer.compare(a.val, b.val));
        inPQ[0][0]=true;
        pq.add(new Tuple(0,0,matrix[0][0]));
        int ans=matrix[0][0];
        while(k>0){
            Tuple pop=pq.remove();
            ans=pop.val;
            //System.out.println(pop.val + " x: "+pop.x+ " y: "+pop.y);
            //check if (x+1,y) has already been put in PQ, if not and x+1<n -> push it
            if(pop.x+1<n && !inPQ[pop.x+1][pop.y]){
                pq.add(new Tuple(pop.x+1,pop.y,matrix[pop.x+1][pop.y]));
                inPQ[pop.x+1][pop.y]=true;
            }
            
            //similarly for (x, y+1)
            if(pop.y+1<n && !inPQ[pop.x][pop.y+1]){
                pq.add(new Tuple(pop.x,pop.y+1,matrix[pop.x][pop.y+1]));
                inPQ[pop.x][pop.y+1]=true;
            }
            k--;
        }
        return ans;
    }

}
