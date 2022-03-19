public class _1423_Maximum_points_you_can_obtain_from_cards {
    // sol 3: sliding window: AC
    // the window is of size n - k. 
    // answer is max(total_sum - window_sum). VISUALIZE
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int w = n - k;
        int sum = 0;
        int ans = 0, total = 0;
        for(int p = 0; p < n; p ++)
            total += cardPoints[p];
        for(int p = 0; p < w; p ++)
            sum += cardPoints[p];
        int i = 0, j = i + w; // [)
        ans = total - sum;
        while(j < n){
            sum = sum - cardPoints[i] + cardPoints[j];
            
            ans = Math.max(ans, total - sum);
            
            i ++;
            j ++;
        }
        return ans;
    }

    // sol 1: Recursive works but TLE
    public int knapsack01(int a[], int i, int j, int k){
        if(k == 0)
            return 0;
        // 2 options
        //1. select i        2. select j
        
        return Math.max(a[i] + knapsack01(a, i + 1, j, k - 1), a[j] + knapsack01(a, i, j - 1, k - 1));
    }
    public int maxScore(int[] cardPoints, int k) {
        return knapsack01(cardPoints, 0, cardPoints.length - 1, k);
    }

    // sol 2: Recursion + memoization - still TLE
    public int knapsack01(int a[], int i, int j, int k, int t[][]){
        if(k == 0)
            return 0;
        if(t[i][j] != -1) return t[i][j];
        // 2 options
        //1. select i        2. select j
        return t[i][j] = Math.max(a[i] + knapsack01(a, i + 1, j, k - 1, t), a[j] + knapsack01(a, i, j - 1, k - 1, t));
    }
    public int maxScore(int[] cardPoints, int k) {
        int t[][] = new int[cardPoints.length][cardPoints.length];
        for(int i = 0; i < cardPoints.length; i ++)
            for(int j = 0; j < cardPoints.length; j ++)
                t[i][j] = -1;
                
        return knapsack01(cardPoints, 0, cardPoints.length - 1, k, t);
    }

    // sol 3: 2 pointers

}
