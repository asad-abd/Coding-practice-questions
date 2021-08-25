//R1 Aug done
//logic: find the volume of water OVER index i. (that's it!)
class _42_TrappingRainWater {
    // O(n^2)
    public int trap(int[] height) {
        int n=height.length;
        int waterVolumeAt[]=new int[n];
        int ans=0;
        for(int i=1;i<n-1;i++){
            int maxLeft=0,maxRight=0;
            for(int j=i-1;j>=0;j--){
                maxLeft=Math.max(maxLeft, height[j]);
            }
            for(int j=i+1;j<n;j++){
                maxRight=Math.max(maxRight, height[j]);
            }
            waterVolumeAt[i]=Math.max(0,Math.min(maxRight,maxLeft)-height[i]);
            ans+=waterVolumeAt[i];
        }
        return ans;
    }
    // O(n)
    public int trap(int[] height) {
        int n=height.length;
        if(n==0)
            return 0;
        int maxHeightLeftAt[]=new int[n];
        int maxHeightRightAt[]=new int[n];
        int ans=0;
        int maxLeft=0;
        int maxRight=0;
        maxHeightLeftAt[0]=height[0];
        for(int i=1;i<n;i++){
            maxLeft=Math.max(maxLeft,height[i-1]);
            maxHeightLeftAt[i]=maxLeft;
        }
        
        maxHeightRightAt[n-1]=height[n-1];
        for(int i=n-2;i>=0;i--){
            maxRight=Math.max(maxRight,height[i+1]);
            maxHeightRightAt[i]=maxRight;
        }
        for(int i=1;i<n-1;i++){
            ans+=Math.max(0,Math.min(maxHeightRightAt[i],maxHeightLeftAt[i])-height[i]);
        }
        return ans;
    }
}
