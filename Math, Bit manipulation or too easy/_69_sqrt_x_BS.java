class Solution {
    public int mySqrt(int num) {
        // Binary search for the number x such that its square is closest to num, i.e., its difference with num should be minimum.
        long minDiff = Integer.MAX_VALUE;
        long st = 0, end = num, mid, ans = num / 2;

        while(st <= end){
            mid = st + (end - st) / 2;
            long x2 = mid * mid;
            // System.out.println(mid + "  answer: " + ans);
            if(x2 == num){
                ans = mid;
                break;
            }
            else if(x2 > num){
                end = mid - 1;
            }
            else{
                if(num - x2 < minDiff){
                    minDiff = num - x2;
                    ans = mid;
                }
                st = mid + 1;
            }
        } 
        return (int)ans;
    }
}
