/* You are standing at position 0 on an infinite number line. There is a goal at position target.

On each move, you can either go left or right. During the n-th move (starting from 1), you take n steps.

Return the minimum number of steps required to reach the destination
*/
//asked in flipkart
class _754_ReachANumber {
    //maths based, AP 1+2+3...+n. some flipped.
    public int reachNumber(int target) {
        target=Math.abs(target);
        int i=1;
        long sum=0, n;
        //n^2 + n - 2*target >=0
        double calc=(Math.sqrt(8*(double)target+1)-1)/2;
        n=(int)Math.ceil(calc);
        sum=(n*(n+1))/2;
        
        System.out.println(n+"  "+sum);
            
        long res=sum-target;
        if(res==0) return (int)n;
        //if resultant is even, flip just one number from x to -x to get == res
        //since x - (-x) = 2 x (x can be any number, we don't care what it is)
        if(res%2==0) return (int)n;
        
        //if resultant is odd, add another odd number to sum to make the res even. And the only possible odd number we can add to avoid duplication is (n+1).
        //Now, we repeat the same step as above, flip an x. In all 2 more steps. But there's a catch. What if n+1 is even??
        //So, if n+1 is even, we add one more n+2 to res. then flip is possible
        if(n%2!=0) return (int)n+2;
        return (int)n+1;
    }
    
    //BFS approach (2^n): seems correct but TLE for large values
    public int canWe(int target) {
        Queue<Integer> q =new LinkedList<>();
        q.add(0);
        int steps=0;
        while(q.size()>0){
            int size=q.size();
            HashSet<Integer> hset=new HashSet<>();
            for(int i=0;i<size;i++){
                int curPos=q.poll();
                if(hset.contains(curPos))
                    continue;
                hset.add(curPos);
                if(curPos==target)
                    return steps;
                
                q.add(curPos+steps+1);
                q.add(curPos-steps-1);
            }
            steps++;
        }
        return steps;
    }
    public int reachNumber(int target) {
        return canWe(target);
    }
}
