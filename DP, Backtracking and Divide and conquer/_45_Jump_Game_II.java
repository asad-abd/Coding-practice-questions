//greedy question, can be done with bfs also (Tle if not O(n))
class _45_Jump_Game_II {
    //greedy + BFS O(n)
    //level 0 is nodeIndex 0.  temp= q.poll()
    // then add all polled nodes in a level => [Math.max(lastIndex,temp), Math.min(n-1, temp+nums[temp])]
    //basically skip the redundant nodes again in the queue.
    //eg, 2,3,1,1,4
    //level 0       2       (add all indices from 1 till 2 in the list)
    //level 1   3*       1  (add all indices from 3 till 1(index of 3 in arr)+3 in the list)
    // just after * we have added all nodes till n-1 in the queue, simply return the value of the next level!
    public int jump(int[] nums) {
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        int last=0;
        int level=0;
        //System.out.println(nums.length);
        while(q.size()>0){
            int size=q.size();
            if(last>=nums.length-1)
                return level;
            for(int i=0;i<size;i++){
                int nodeIndex=q.poll();
                int end=Math.min(nums.length-1,nodeIndex+nums[nodeIndex]);
                
                if(end>=nums.length-1) return level+1;
                for(int k=last+1;k<=end; k++){
                    //System.out.println("k: "+k);
                    q.add(k);
                }
                last=Math.max(last,Math.min(nums.length-1,nodeIndex+nums[nodeIndex]));
            }
            level++;
        }
        return level;
    }
    //dp: correct but TLE O(n^2)
    public int jump(int[] nums) {
        int [] t=new int[1000000];
        t[0]=0;
        for(int i=1;i<nums.length;i++)
            t[i]=Integer.MAX_VALUE-1;
        for(int i=1;i<nums.length;i++)
            for(int k=i-1;k>=0;k--)
                if(nums[k]+k>=i)
                    t[i]=Math.min(t[i], t[k]+1);
            
        
        //t[i]=min number of jumps from i to reach the end
        return t[nums.length-1];
    }
}
