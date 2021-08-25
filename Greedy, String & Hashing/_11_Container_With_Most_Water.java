public class _11_Container_With_Most_Water {
    //M1: trivial O(n^2) solution
    //M2: 2 pointer!
    //consider the 0 and (n-1)th lines and take the area. then ++/-- the one that is smaller
    public int maxArea(int[] height) {
        //review with the proof/ explanation of 2 ptr approach
        int i = 0, j = height.length - 1;
        int ans = Integer.MIN_VALUE;
        int temp;
        while(j > i){
            temp = (j - i) * Math.min(height[i], height[j]);
            ans = Math.max(ans, temp);
            if(height[i] > height[j])
                j --;
            else if(height[i] == height[j]){
                i ++;
                j --;
            }
            else
                i ++;
        }
        return ans;
    }
}
