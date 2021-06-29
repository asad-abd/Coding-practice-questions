public class _gfg_job_sequencing_problem {
    //ONLY LOGIC AS OF NOW
    //sort based on profit(desc)
    //place the current max profit job in such a way that we are certain of making a profit from it
    //but also leaving space for some other job with lesser profit but that may have smaller deadline
    //so schedule job just before its deadline. if that spot is already taken, move backwards till an empty slot.
    //naive in O(n^2)
    
    //below is not solved completely: O(n^2) is easy and nlogn has disjoint sets.
    int[] JobScheduling(Job arr[], int n)
    {
        //sort based on deadlines, if same deadlines, sort based on profits
        //increase time and if time > current job's deadline (iterate over to a profitable job)
        Arrays.sort(arr, (a,b)->Integer.compare(-a.profit,-b.profit));
        int time=0,i=0;
        int countJobs=0, profit=0;
        while(i<n){
            while(i<n && arr[i].deadline<=time)
                i++;
            if(i==n) break;
            profit+=arr[i].profit;
            countJobs++;
            time++;
            
        }
        return new int[]{countJobs, profit};
    }
}
