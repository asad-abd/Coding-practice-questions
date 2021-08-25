class _973_K_Closest_Points_to_origin {
    //approach 3: Quick Select ----- I. M. P.
    //error in the code (can't figure out what) 
    //based on quickselect
    //select random pt in (l, r) and take it as pivot.
    //after the pivot(p) is in its correct place if p > k. then recurse on the lhs (l, p-1). else ..
    public int quickselect(int nums[], int l, int r, int k){
        //we want p to be (k - 1)
        int random = l + (int)(Math.random()*(r - l));
        //System.out.println(random + " l: "+l+"  r: "+r);
        swap(nums, l, random);
        int pivot = l;
        for(int i = l + 1; i <= r; i ++){
            if(nums[pivot] >= nums[i]){
                //move pivot ahead by 1 to make place for i
                //eg: 3, 2, 1, 5(p), 6, 4(i)
                //swap 5 with 6(p+1)
                //  3, 2, 1, 6(p), 5, 4(i)
                //swap i with p
                //  3, 2, 1, 4(p), 5, 6(i)
                //increment p
                //  3, 2, 1, 4, 5(p), 6(i)
                swap(nums, pivot, i);
                swap(nums, pivot, pivot + 1);
                
                pivot ++;
            }
        }
        System.out.println(pivot + " l: "+l+"  r: "+r);
        System.out.println(Arrays.toString(nums));
        return pivot - 1;
    }
    public void swap(int nums[], int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
        //nums[i] = nums[j] + nums[i];
        //nums[j] = nums[i] - nums[j]; // nums[i] 
        //nums[i] = nums[i] - nums[j]; // nums[j]
    }
    public int findKthLargest(int[] nums, int k) {
        int l = 0, r = nums.length - 1, pivot = 0;
        //change k since I have written quickselect for ascending order 
        k = r - k + 1;
        while(l <= r){
            pivot = quickselect(nums, l, r, k);
            //System.out.println(Arrays.toString(nums));
            if(pivot < k - 1)
                l = pivot + 1;
            else if(pivot > k - 1)
                r = pivot - 1;
            else
                break;
        }
        return nums[pivot];
    }
    
    //approach 1: O(n*log(n)) sorting
    public int[][] kClosest(int[][] points, int k) {
        Arrays.sort(points, (a,b) -> (Integer.compare(a[0]*a[0]+a[1]*a[1], b[0]*b[0]+b[1]*b[1])));
        int ans[][] = new int[k][2];
        for(int i = 0; i < k; i++){
            ans[i][0] = points[i][0];
            ans[i][1] = points[i][1];
        }
        return ans;
    }

    //approach 2: O(n*log(k)) max heap/priority queue 
    public int[][] kClosest2(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> (b[0]*b[0]+b[1]*b[1] - a[0]*a[0]/*FOOL! not + */ - a[1]*a[1]));
        //if (a,b). use b-a for max heap!!!
        //since we're removing the max, that is the TOP!!
        int ans[][] = new int[k][2];
        //max heap because we want to remove easily from the top
        int i=0;
        while(i<points.length){
            pq.add(points[i++]);
            while(pq.size()>k)
                pq.poll();
        }
        i=0;
        while(i<k){
            ans[i++] = pq.poll();
        }
        return ans;
    }
}
