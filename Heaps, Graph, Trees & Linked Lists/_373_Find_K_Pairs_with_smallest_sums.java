class _373_Find_K_Pairs_with_smallest_sums {
    //33% better - O(n^2)
    public class Obj{
        int i,j,sum;
        Obj(int a, int b, int s){
            i=a;
            j=b;
            sum=s;
        }
    }
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<Obj> pq=new PriorityQueue<>((a,b)->Integer.compare(a.sum,b.sum));
        //create all possible pairs of (a,b) where a is in nums1 and b is in nums2
        //pop the top k. that's it. but O(n^2). improve to nlogk.
        for(int i=0;i<nums1.length;i++){
            for(int j=0;j<nums2.length;j++){
                Obj nObj=new Obj(i,j,nums1[i]+nums2[j]);
                pq.add(nObj);
            }
        }
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<k && pq.size()>0;i++){
            Obj nObj=pq.remove();
            List<Integer> ans_obj=new ArrayList<>();
            ans_obj.add(nums1[nObj.i]);
            ans_obj.add(nums2[nObj.j]);
            ans.add(ans_obj);
        }
        return ans;
    }
}
