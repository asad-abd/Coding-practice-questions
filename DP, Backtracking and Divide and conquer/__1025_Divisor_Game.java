public class __1025_Divisor_Game {
    //How will current player move?
    //He doesn't know which x to subtract in current step to eventually win.
    //Consider all possible xs at this step
    //At each step we want to select a number such that eventually the other person loses.
    
    //3. Maths - extrapolate using induction
    public boolean divisorGame(int n) {
        return n % 2 == 0;
        
        //1 - false
        //2 - true
        //3 - false
        //4 - true
        //...
        //odd number has odd factore -> odd - odd is even (bob get even and wins)...(YT Fraz)
    }

    //2. Recursive + memo
    public boolean divisorGameUtil(int n, int t[]) {
        //returns whether a player(can be anyone) can win or not
        if(n == 2) return true;
        if(n == 1) return false;
        
        if(t[n] != 0) return t[n] == 1? true: false;
        
        for(int x = 1; x * x <= n; x ++){
            if(n % x == 0){//divisor
                //check if the next player can eventually lose if current player selects x to subtract from n in this step.
                if(divisorGameUtil(n - x, t) == false){
                    t[n] = 1;
                    return true;
                }
                if(n / x != n){
                    if(divisorGameUtil(n - n/x, t) == false){
                        t[n] = 1;
                        return true;
                    }
                }
            }
        }
        t[n] = -1;
        return false;
    }
    public boolean divisorGame(int n) {
        int t[] = new int[n + 1];
        return divisorGameUtil(n, t);
    }

    //1. Recursive only - (YT Fraz) TLE
    public boolean divisorGameUtil(int n) {
        //returns whether a player(can be anyone) can win or not
        if(n == 2) return true;
        if(n == 1) return false;
        
        for(int x = 1; x * x <= n; x ++){
            if(n % x == 0){//divisor
                //check if the next player can eventually lose if current player selects x to subtract from n in this step.
                if(divisorGameUtil(n - x) == false)
                    return true;
                
                if(n / x != n){
                    if(divisorGameUtil(n - n/x) == false)
                    return true;
                }
            }
        }
        return false;
    }
    public boolean divisorGame(int n) {
        return divisorGameUtil(n);
    }

    //I was also trying bfs - level order traversal
}
