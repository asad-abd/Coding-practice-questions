class __621_Task_Scheduler_greedy {
    //cycles of n + 1.
    //break the last cycle in between if the total tasks(m) are done
    public int leastInterval(char[] tasks, int n) {
        if(n == 0) return tasks.length;
        
        int[] freq = new int[26];
        Arrays.sort(freq);
        
        int time = 0, m = 0;
        for(char c : tasks){
            freq[c - 'A']++;
            m++;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b - a);
        for(int f : freq)
            if(f > 0)
                pq.add(f);
        
        //cycles of n + 1.
        while(pq.size() > 0){
            List<Integer> unFinishedTasks = new ArrayList<>();
            for(int i = 0; i < n + 1; i ++){
                if(m == 0) break;
                if(pq.size() > 0){
                    int task = pq.poll();
                    if(task > 1)
                        unFinishedTasks.add(task - 1);
                    m--;
                }
                //keep adding time if the tasks remain (m>0) but all have already been assigned once to this cycle
                time++;
                //if we want instead of doing t++ outside, we can break the loop by adding (n + 1 - i) to time in the else part
                //else{
                //    time += (n + 1 - i);
                //    break;
                //}
            }
            for(int leftTask : unFinishedTasks)
                pq.add(leftTask);
        }
        return time;
    }
}
