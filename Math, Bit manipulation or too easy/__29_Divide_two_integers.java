public class __29_Divide_two_integers {
    //https://www.youtube.com/watch?v=6kFp_s_UtPE
    //instead of subtracting x in each turn we'll say that if we can subtract x from y then maybe we can also subtract some multiples of x. (like 2x => x + x)
    //so on we can subtract x, 2x, 4x, 8x and so on untill we can't
    //had to use long for x and y, or else many overflow cases. 
    //O(logn) solution. can be done in O(32) as well by bit manipulation. (can argue that it is multiplication)
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1)// since abs(+ve IINF) + 1 = abs(-ve IINF) - we need to avoid overflow in this case.
            return Integer.MAX_VALUE;// (2^31 - 1)
        
        long ans = 0;
        
        boolean positive = true;
        if(dividend <= 0 && divisor < 0 || dividend >= 0 && divisor > 0)
            positive = true;
        else
            positive = false;
        
        long x = Math.abs((long)divisor);
        long y = Math.abs((long)dividend);
        while(y >= x){ // y/x
            long timesX = 1; 
            long timesXprod = x;
            while(y >= timesXprod && y >= 0 && timesXprod >= 0){//-ve check to avoid overflow for Xprod to become -IINF
                //System.out.println(y+"\tx: "+timesXprod);
                ans += timesX;
                y -= timesXprod;
                timesXprod += timesXprod; // doubles in every step
                timesX += timesX; // doubles in every step
            }
        }
        
        if(!positive)
            return -(int)ans;
        return (int)ans;
    }
}
